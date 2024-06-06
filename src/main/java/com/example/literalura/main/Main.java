package com.example.literalura.main;

import com.example.literalura.models.*;
import com.example.literalura.repository.AuthorRepository;
import com.example.literalura.repository.BookRepository;
import com.example.literalura.services.ConsumptionApi;
import com.example.literalura.services.JsonResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private ConsumptionApi request = new ConsumptionApi();
    private JsonResponse convert = new JsonResponse();
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private int option = -1;
    private Scanner reader = new Scanner(System.in);
    private String startMenu = """
                    
                    Choose option by number:
                    1 - Find book by title
                    2 - List registered books
                    3 - List registered authors
                    4 - List living authors in a given year
                    5 - List books by language
                    0 - Exit                                 
                    """;



    public Main(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public void menu(){

        while(option != 0){
            System.out.println(startMenu);
            option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    bookFound();
                    break;

                case 2:
                    allBooks();
                    break;

                case 3:
                    allAuthors();
                    break;
                case 4:
                    authorsPerYear();
                    break;
                case 5:
                    booksPerLanguage();
                    break;
                case 0:
                    System.out.println("Thanks for use Literalura");
                    break;
                default:
                    System.out.println("Choose a valid option");

            }
        }
    }

    private void booksPerLanguage() {
        System.out.println("Choose a language" +
                "\nen - English" +
                "\nes - Spanish" +
                "\nfr - French" +
                "\npt - Portuguese");
        String test = reader.nextLine();
        List<String> language = new ArrayList<>();
        language.add(test);
        List<ResultsClass> book = bookRepository.findByLanguageBook(language);
        if(book.isEmpty()){
            System.out.println("Doesn't contain this language in listed books");
        } else {
            book.stream()
                    .forEach(System.out::println);
        }
    }

    private void authorsPerYear() {
        System.out.println("Type it a year");
        int year = reader.nextInt();
        authorRepository.livingAuthors(year).stream()
                .forEach(System.out::println);
    }

    private void allAuthors() {
        authorRepository.findAll().stream()
                .forEach(System.out::println);
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

    public void allBooks(){
        bookRepository.findAll().stream()
                .forEach(System.out::println);

    }


    public void bookFound(){
        ResultsClass book = finderBook();
        System.out.println(book);
        bookRepository.save(book);
    }
}
