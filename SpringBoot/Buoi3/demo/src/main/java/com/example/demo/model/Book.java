package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder

public class Book {
    private int id;
    private  String title;
    private  String author;
    private int year;

}

