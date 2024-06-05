package com.example.literalura.main;

import com.example.literalura.models.BooksRecord;
import com.example.literalura.models.Results;
import com.example.literalura.services.ConsumptionApi;
import com.example.literalura.services.JsonResponse;
import org.apache.logging.log4j.message.ReusableMessage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public void menu(){
        ConsumptionApi request = new ConsumptionApi();
        JsonResponse convert = new JsonResponse();
//        Scanner reader = new Scanner(System.in);
//
//        System.out.println("Digite um livro que deseja procurar");
//        String bookSearch = reader.nextLine();
//        System.out.println(bookSearch);
        String json = request.obtainData();
        BooksRecord books = convert.jsonConvert(json, BooksRecord.class);
        System.out.println(books.livros().get(0));


    }
}
