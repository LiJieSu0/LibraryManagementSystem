package com.lijie_su.library_management_system.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.lijie_su.library_management_system.lending_record.LendingRecord;
import com.lijie_su.library_management_system.lending_record.LendingRecordRepository;
import com.lijie_su.library_management_system.user.User;
import com.lijie_su.library_management_system.user.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LendingRecordRepository lendingRecordRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository,LendingRecordRepository lendingRecordRepository,UserRepository userRepository){
        this.bookRepository=bookRepository;
        this.lendingRecordRepository=lendingRecordRepository;
        this.userRepository=userRepository;
    }
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    public void registerNewBook(Book newBook) {
        Optional<Book> bookOptional=bookRepository.findBookByName(newBook.getBook_name());
        if(bookOptional.isPresent()){
            updateBookAmount(newBook.getBook_name(), newBook.getCurr_amount());
            // throw new IllegalStateException("Book is exist");
        }
        else{
            bookRepository.save(newBook);
        }
    }

    @Transactional
    public void updateBookAmount(Long id,int amount){
        Book b=bookRepository.findById(id).orElseThrow(()->new IllegalStateException("Book id is not exist"));
        int updateBookAmount;
        if(b.getCurr_amount()+amount<0){
            updateBookAmount=0;
        }
        else{
            updateBookAmount=b.getCurr_amount()+amount;
        }
        b.setCurr_amount(updateBookAmount);
    }

    @Transactional
    public void updateBookAmount(String book_name,int amount){
        Book b=bookRepository.findBookByName(book_name).orElseThrow(()->new IllegalStateException("Book id is not exist"));
        int updateBookAmount;
        if(b.getCurr_amount()+amount<0){
            updateBookAmount=0;
        }
        else{
            updateBookAmount=b.getCurr_amount()+amount;
        }
        bookRepository.save(b);      
    }

    public void lendingBook(List<Long> books_id, Long user_id) {
        Optional<User> userOptional=userRepository.findById(user_id);
        if(!userOptional.isPresent()){
            throw new IllegalStateException("User id "+user_id+" is not exist.");
        }
        for(var i:books_id){
            Optional<Book> tmp=bookRepository.findById(i);
            if(!tmp.isPresent()){
                throw new IllegalStateException("The book id "+ i+" is not exist.");
            }
            else{
                Book b=tmp.get();
                if(b.getCurr_amount()==0){
                    throw new IllegalStateException("The book id "+ i+" is not in library.");
                }
                else{
                    b.setCurr_amount(b.getCurr_amount()-1);
                    if(b.getBorrower_id()==null){
                        List<Long> borrower_idList=new ArrayList();
                        borrower_idList.add(user_id);
                        b.setBorrower_id(borrower_idList);
                    }
                    else{
                        b.addBorrower_id(user_id);
                    }
                    bookRepository.save(b);
                }
            }
        }
        LendingRecord record=new LendingRecord(user_id, LocalDate.now(), books_id);
        lendingRecordRepository.save(record);
    }

}
