package com.example.literalura.repository;

import com.example.literalura.models.ResultsClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<ResultsClass, Long>{
}
