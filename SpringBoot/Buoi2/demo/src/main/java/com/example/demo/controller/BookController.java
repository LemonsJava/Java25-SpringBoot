package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
- Controller: Noi tiep nhan cac request tu client, xu ly va tra ve cac response
- @Controller: Cac controllers tra ve giao dien (Template). Ngoai ra co the tra ve du lieu dang JSON, XML
- @RestController: Cac controllers tra ve du lieu dang JSON
 */

@RestController
@RequestMapping("/books")

public class BookController {
    List<Book> books = new ArrayList<Book>(List.of(
            new Book(1, "Book 1", "Author 1", 100),
            new Book(2, "Book 2", "Author 2", 200),
            new Book(3, "Book 3", "Author 3", 300)
    ));
    // Lay danh sach tat ca sach
    @GetMapping  //GET: https://localhost:8080/books
    public List<Book> getAllBooks() {
        return books;
    }


    // Lay danh sach theo ID
    @GetMapping("/{id}")  //GET: https://localhost:8080/books/1
    public Book getBookById(@PathVariable int id) {
        return books.stream()
               .filter(book -> book.getId() == id)
               .findFirst()
               .orElse(null);
        // Nếu id không tồn tại trong danh sách, trả về null
        // Nếu id tồn tại, trả về thông tin của sách

    }

    @GetMapping("/title/{title}")  //GET: https://localhost:8080/books/title/Book 1
    public List<Book> getBookByTitle(@PathVariable String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }

    // Sap xep theo nam giam dan
    @GetMapping("/sort-by-year")  //GET: https://localhost:8080/books/sort-by-ear
    public List<Book> getBookByYear() {
        return books.stream()
                .sorted((b1, b2) -> b2.getYear() - b1.getYear())
                .toList();
    }

    //Tim kiem sach trong khoang thoi gian(fromYear. toYear)
    @GetMapping("/rangeYear/{fromYear}/{toYear}")  //GET: https://localhost:8080/books/rangeYear/2000/2020
    public List<Book> getBookByRange(@PathVariable int fromYear, @PathVariable int toYear) {
        return books.stream()
                .filter(book -> book.getYear() >= fromYear && book.getYear() <= toYear)
                .toList();
    }
}
