package com.example.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Authors(@JsonAlias("name") String name,
                      @JsonAlias("birth_year") Integer born,
                      @JsonAlias("death_year") Integer death) {
    @Override
    public String toString() {
        return "name = " + name +
                ", born = " + born +
                ", death=" + death;
    }
}
