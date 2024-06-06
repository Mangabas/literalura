package com.example.literalura.repository;

import com.example.literalura.models.AuthorClass;
import com.example.literalura.models.ResultsClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<ResultsClass, Long>{

    List<ResultsClass> findByLanguageBook(List<String> language);

}
