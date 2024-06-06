package com.example.literalura.models;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class AuthorClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    private int authorBorn;
    private int authorDeath;
    @ManyToOne
    private ResultsClass book;

    public AuthorClass(){}

    @Override
    public String toString() {
        return "Name = " + authorName +
                ", Born date = " + authorBorn +
                ", Death date = " + authorDeath;
    }

    public AuthorClass(Authors authors) {
        this.authorName = authors.name();
        this.authorBorn = authors.born();
        this.authorDeath = authors.death();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorBorn() {
        return authorBorn;
    }

    public void setAuthorBorn(int authorBorn) {
        this.authorBorn = authorBorn;
    }

    public int getAuthorDeath() {
        return authorDeath;
    }

    public void setAuthorDeath(int authorDeath) {
        this.authorDeath = authorDeath;
    }

    public void setBook(ResultsClass results){
        this.book = results;
    }
}
