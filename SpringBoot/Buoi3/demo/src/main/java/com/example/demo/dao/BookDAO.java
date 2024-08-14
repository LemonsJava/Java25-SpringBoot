package com.example.demo.dao;

import com.example.demo.model.Book;
import java.util.List;

public interface BookDAO {

  Book findById(int id);

  List<Book> findByTitleContainIgnoreCase(String keyword);


  List<Book> findByYearBetween(int fromYear, int toYear);

  List<Book> findAll();

  List<Book> sortByYear();
}
