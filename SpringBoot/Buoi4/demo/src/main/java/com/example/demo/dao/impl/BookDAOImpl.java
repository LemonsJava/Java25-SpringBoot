package com.example.demo.dao.impl;

import com.example.demo.dao.BookDAO;
import com.example.demo.database.BookDB;
import com.example.demo.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {

  @Override
  public Book findById(int id) {
    for (Book book : BookDB.books) { //SELECT * FROM books WHERE id = ?
      if (book.getId() == id) {
        return book;
      }
    }
    return null;
  }

  @Override
  public List<Book> findByTitleContainIgnoreCase(
      String keyword) { //SQL: SELECT * FROM books WHERE title LIKE '%keyword%'
    List<Book> result = new ArrayList<>();
    for (Book book : BookDB.books) {
      if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        result.add(book);
      }
    }
    return result;
  }

  @Override
  public List<Book> findByYearBetween(int fromYear, int toYear) {
    List<Book> result = new ArrayList<>();
    for (Book book : BookDB.books) {
      if (book.getYear() >= fromYear && book.getYear() <= toYear) {
        result.add(book);
      }
    }
    return result;
  }

  @Override
  public List<Book> findAll() {
    return BookDB.books;
  }

  @Override
  public List<Book> sortByYear() {
    return BookDB.books.stream()
        .sorted((b1, b2) -> Integer.compare(b2.getYear(), b1.getYear()))
        .toList();
  }

}
