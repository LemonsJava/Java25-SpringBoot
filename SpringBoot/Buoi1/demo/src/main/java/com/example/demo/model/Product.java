package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

// import Lombok

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private String brand;
}
