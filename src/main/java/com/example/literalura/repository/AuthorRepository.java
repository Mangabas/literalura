package com.example.literalura.repository;

import com.example.literalura.models.AuthorClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorClass, Long> {

    @Query("SELECT a FROM AuthorClass a WHERE :year <= a.authorDeath AND :year >= a.authorBorn")
    List<AuthorClass> livingAuthors(int year);
}
