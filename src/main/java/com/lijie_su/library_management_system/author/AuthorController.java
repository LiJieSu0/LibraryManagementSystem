package com.lijie_su.library_management_system.author;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lijie_su.library_management_system.user.User;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path="api/v1/author")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }
    @GetMapping
    public List<Author> getAllAuthors(){
        return  authorService.getAllAuthors();       
    }
    @GetMapping(path="{user_name}")
    public Author findAuthorByName(@PathVariable String name){
        return authorService.findAuthorByName(name);
    }
}
