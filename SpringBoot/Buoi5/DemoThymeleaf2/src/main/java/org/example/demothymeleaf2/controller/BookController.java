package org.example.demothymeleaf2.controller;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.example.demothymeleaf2.model.Book;
import org.example.demothymeleaf2.model.IPageResponse;
import org.example.demothymeleaf2.model.PageResponseImlp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

  List<Book> books = new ArrayList<>();

  public BookController() {
    Faker faker = new Faker();
    for (int i = 1; i < 51; i++) {
      Book book = Book.builder()
          .id(i)
          .title(faker.book().title())
          .author(faker.book().author())
          .year(faker.number().numberBetween(1900, 2020))
          .build();
      books.add(book);
    }
  }

  @GetMapping
  public String getAllBooks(Model model, @RequestParam(required = false) String title) {
    List<Book> newBooks;
    if (title != null) {
      newBooks = books.stream()
          .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
          .collect(Collectors.toList());
    } else {
      newBooks = books;
    }
    Book book = books.get(0);
    model.addAttribute("book", book);
    model.addAttribute("books", newBooks);
    return "index";
  }

  // Phan trang http://localhost:8080/books?page=1&size=10
  //currentPage: Trang hien tai
  //PageSizes: So ban ghi tren mot trang
  //totalElements: Tong so ban ghi
  //totalPages: Tong so trang = totalElements / PageSizes
  //Content: Danh sach cac ban ghi tren trang hien tai


  @GetMapping("/books")
  public String getBooksPage(@RequestParam(defaultValue = "1", required = false) int page,
      @RequestParam(defaultValue = "10", required = false) int size,
      Model model) {
    IPageResponse<Book> pageResponse = PageResponseImlp.<Book>builder()
        .currentPage(page)
        .pageSize(size)
        .data(books)
        .build();

    model.addAttribute("pageResponse", pageResponse);
    return "books";
  }

  @GetMapping("/blog")
  public String getBlog(Model model) {
    Book book = books.get(1);
    model.addAttribute("book", book);
    return "admin/blog";
  }

  @GetMapping("/books/{id}")
  public String getBookById(@PathVariable int id, Model model) {
    Book book = books.stream()
        .filter(b -> b.getId() == id)
        .findFirst()
        .orElse(null);

    List<Book> relatedBooks = books.stream()
        .filter(b -> {
          assert book != null;
          return b.getAuthor() == book.getAuthor() && b.getId() != book.getId();
        })
        .sorted((b1, b2) -> b2.getYear() - b1.getYear())
        .limit(4)
        .collect(Collectors.toList());

    model.addAttribute("book", book);
    model.addAttribute("relatedBooks", relatedBooks);

    return "book-detail";
  }

}
