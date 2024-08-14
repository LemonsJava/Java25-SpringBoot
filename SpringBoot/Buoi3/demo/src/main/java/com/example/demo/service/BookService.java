package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.List;

public interface BookService {

  List<Book> getAllBooks();

  Book findBookById(int id);

  List<Book> findBookByTillIe(String keyword);

  List<Book> findBookBetweenYears(int fromYear, int toYear);

  List<Book> sortBooksByYear();
}
