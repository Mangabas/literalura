package com.example.literalura.main;

import com.example.literalura.models.*;
import com.example.literalura.services.ConsumptionApi;
import com.example.literalura.services.JsonResponse;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    ConsumptionApi request = new ConsumptionApi();
    JsonResponse convert = new JsonResponse();
    int option = -1;
    Scanner reader = new Scanner(System.in);
    String startMenu = """
                    Choose option by number:
                    1 - Find book by title
                    2 - List registered books
                    3 - List registered authors
                    4 - List living authors in a given year
                    5 - List books by language
                    0 - Exit                                 
                    """;


    public void menu(){

        while(option != 0){
            System.out.println(startMenu);
            option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    bookFound();
                    break;
                default:
                    System.out.println("Choose a valid option");

            }
        }
    }


    public ResultsClass finderBook(){
        System.out.println("Write a title of a book");
        String bookName = reader.nextLine();
        String json = request.obtainData(bookName);
        BooksRecord books = convert.jsonConvert(json, BooksRecord.class);
        List<AuthorClass> authorsList = books.livros().get(0).authors().stream()
                .map(a -> new AuthorClass(a))
                .collect(Collectors.toList());
        ResultsClass data = new ResultsClass(books.livros().get(0));
        data.setAuthorClass(authorsList);

        return data;
    }


    public void bookFound(){
        ResultsClass book = finderBook();
        System.out.println(book);



    }
}
