package com.lijie_su.library_management_system.book;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lijie_su.library_management_system.user.User;
import com.lijie_su.library_management_system.user.UserRepository;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository,UserRepository userRepository){
        return args->{
            Book firstBook=new Book("one pig", List.of("child"), 2,LocalDate.of(2000,Month.JANUARY,5), List.of(1L));
            Book secondBook=new Book("second pig", List.of("child"), 2,LocalDate.of(2000,Month.JANUARY,5), List.of(2L));
            Book thirdBook=new Book("third pig", List.of("child"), 2,LocalDate.of(2000,Month.JANUARY,5), List.of(3L));

            User user1=new User("Jack","jack@gmail.com", "Normal", LocalDate.now());
            User user2=new User("Bob","bob@gmail.com", "Normal", LocalDate.now());
            User user3=new User("Lucy","lucy@gmail.com", "Normal", LocalDate.now());

            userRepository.saveAll(List.of(user1,user2,user3));
            bookRepository.saveAll(List.of(firstBook,secondBook,thirdBook));
        };
    }
}
