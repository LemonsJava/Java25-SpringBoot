package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
  private final List<Book> books = new ArrayList<>(List.of(
      new Book(1, "Spring Boot", "John Smith", 2019),
      new Book(2, "Java Programming", "Anna Smith", 2020),
      new Book(3, "Python Programming", "author 3", 2021),
      new Book(4, "Code with Harry", "Bob Smith", 2022)
  ));
  // http://locolhost:8080 -> Hien thi template index.html
  @GetMapping
  public String getHomePage() {
    return "index";
  }

  //http://locolhost:8080/blog -> Hien thi template blog.html
  @GetMapping("/blog")
  public String getBlogPage() {
    return "admin/blog";
  }

}
