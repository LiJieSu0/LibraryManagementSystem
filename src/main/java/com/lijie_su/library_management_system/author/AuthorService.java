package com.lijie_su.library_management_system.author;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    public Author findAuthorByName(String name){
        Optional<Author> a= authorRepository.findAuthorByName(name);
        if(!a.isPresent()){
            throw new IllegalStateException("Author is not exist.");
        }
        return a.get();
    }
}
