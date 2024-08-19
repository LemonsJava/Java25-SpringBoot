package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
- Controller: Noi tiep nhan cac request tu client, xu ly va tra ve cac response
- @Controller: Cac controllers tra ve giao dien (Template). Ngoai ra co the tra ve du lieu dang JSON, XML
- @RestController: Cac controllers tra ve du lieu dang JSON
 */

@RestController
@RequestMapping("/books")

public class BookController {

  @Autowired
  private BookService bookService;

  // Lay danh sach tat ca book
  @GetMapping  //GET: https://localhost:8080/books
  public ResponseEntity<List<Book>> getAllBook() {
    List<Book> books = bookService.getAllBooks();Con
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  //
//
  // Lay danh sach theo ID
  @GetMapping("/{id}")  //GET: https://localhost:8080/books/1
  public ResponseEntity<Book> getBookById(@PathVariable int id) {
    Book book = bookService.findBookById(id);
    if (book == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(book, HttpStatus.OK);
    }
  }

  //
  @GetMapping("/title/{title}")  //GET: https://localhost:8080/books/title/Book 1
  public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
    List<Book> books = bookService.findBookByTillIe(title);
    return ResponseEntity.ok(books);
  }

  // Sap xep theo nam giam dan
  @GetMapping("/sort-by-year")  //GET: https://localhost:8080/books/sort-by-ear
  public List<Book> getBookByYear() {
    return bookService.sortBooksByYear();
  }

  //Tim kiem sach trong khoang thoi gian(fromYear. toYear)
  @GetMapping("/rangeYear/{fromYear}/{toYear}")
  //GET: https://localhost:8080/books/rangeYear/2000/2020
  public List<Book> getBookByRange(@PathVariable int fromYear, @PathVariable int toYear) {
    return bookService.findBookBetweenYears(fromYear, toYear);
  }
}
