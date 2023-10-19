package com.lijie_su.library_management_system.book;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lijie_su.library_management_system.lending_record.LendingRecord;
import com.lijie_su.library_management_system.lending_record.LendingRecordRepository;

@RestController
@RequestMapping(path="api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService,LendingRecordRepository lendingRecordRepository){
        this.bookService=bookService;
    }
    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(path="{book_name}")
    public Book findBookByName(@PathVariable String book_name){
        return bookService.findBookByName(book_name);
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book newBook){
        bookService.registerNewBook(newBook);
    }

    @PostMapping(path="lending/{user_id}")
    public void lendingBook(@RequestBody List<Long> books_id,@PathVariable Long user_id){
        bookService.lendingBook(books_id,user_id);
    }
    @PostMapping(path="return/{user_id}")
    public void returnBook(@RequestBody List<Long> books_id, @PathVariable Long user_id){
        bookService.returnBook(books_id,user_id);
    }

    @PutMapping(path="/id/{book_id}")
    public void updateBookAmount(@PathVariable Long book_id, @RequestParam int amount){
        bookService.updateBookAmount(book_id, amount);
    }
    @PutMapping(path="/name/{book_name}")
    public void updateBookAmount(@PathVariable String book_name, @RequestParam int amount){
        bookService.updateBookAmount(book_name, amount);
    }
}
