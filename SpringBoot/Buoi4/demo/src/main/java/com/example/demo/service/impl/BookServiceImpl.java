package com.example.demo.service.impl;

import com.example.demo.dao.BookDAO;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class BookServiceImpl implements BookService {

  @Autowired
  private BookDAO bookDAO;

  @Override
  public List<Book> getAllBooks() {
    return bookDAO.findAll();
  }

  @Override
  public Book findBookById(int id) {
    return bookDAO.findById(id);
  }

  @Override
  public List<Book> findBookByTillIe(String keyword) {
    return bookDAO.findByTitleContainIgnoreCase(keyword);
  }

  @Override
  public List<Book> findBookBetweenYears(int fromYear, int toYear) {
    return bookDAO.findByYearBetween(fromYear, toYear);
  }

  @Override
  public List<Book> sortBooksByYear() {
    return bookDAO.sortByYear();
  }

}
