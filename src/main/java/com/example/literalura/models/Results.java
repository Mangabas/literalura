package com.example.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(@JsonAlias("id") Integer id,
                      @JsonAlias("title") String title,
                      @JsonAlias("authors") List<Authors> authors,
                      @JsonAlias("languages") List<String> language) {
    @Override
    public String toString() {
        return "id = " + id +
                "\ntitle = " + title +
                "\nauthors = " + authors +
                "\nlanguage = " + language;
    }
}
