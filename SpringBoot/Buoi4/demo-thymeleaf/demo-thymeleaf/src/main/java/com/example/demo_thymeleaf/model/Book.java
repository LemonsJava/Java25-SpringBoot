package com.example.demo_thymeleaf.model;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Builder

@Controller
public class Book {
  private int id;
  private String title;
  private String author;
  private int year;

}
