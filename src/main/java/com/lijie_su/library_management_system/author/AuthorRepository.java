package com.lijie_su.library_management_system.author;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{
    @Query("SELECT a FROM Author a WHERE a.name=?1")
    Optional<Author>findAuthorByName(String name);
}
