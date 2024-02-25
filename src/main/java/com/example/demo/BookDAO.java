package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(100, "Core Java", 400L));
        books.add(new Book(102, "JPA", 100L));
        books.add(new Book(103, "Hibernate", 300L));
        books.add(new Book(103, "Angular", 300L));
        books.add(new Book(104, "Spring Core", 500L));
        books.add(new Book(104, "Spring Boot", 400L));
        books.add(new Book(104, "Spring", 500L));
        books.add(new Book(104, "Spring Core 2", 500L));
        books.add(new Book(104, "Spring Core 1", 500L));
        return books;
    }
}
