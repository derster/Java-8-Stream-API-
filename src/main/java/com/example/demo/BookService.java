package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
@Service
public class BookService {
    public List<Book> getBookInSort(){
        List<Book> books = new BookDAO().getBooks();

        books.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));

        return books;
    }
}
class MyComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
