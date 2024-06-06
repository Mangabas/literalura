package com.example.literalura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class ResultsClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idBook;
    private String titleBook;
    private List<String> languageBook;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AuthorClass> authorBook;
    public ResultsClass(){}

    public void setAuthorClass(List<AuthorClass> authorBook) {
        authorBook.forEach(a -> a.setBook(this));
        this.authorBook = authorBook;
    }

    public ResultsClass(Results results) {
        this.idBook = String.valueOf(results.id());
        this.titleBook = results.title();
        this.languageBook = results.language();
    }

    @Override
    public String toString() {
        return "Title = " + titleBook +
                ", Language = " + languageBook +
                ", Author = " + authorBook;
    }
}
