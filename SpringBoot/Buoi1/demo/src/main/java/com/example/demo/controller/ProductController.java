package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Product 1", "San pham thu 1", 100, "Brand 1" ),
            new Product(2, "Product 2", "San pham thu 2", 200, "Brand 2" ),
            new Product(3, "Product 3", "San pham thu 3", 300, "Brand 3" ),
            new Product(4, "Product 4", "San pham thu 4", 400, "Brand 4" ),
            new Product(5, "Product 5", "San pham thu 5", 500, "Brand 5" ),
            new Product(6, "Product 6", "San pham thu 6", 600, "Brand 6" ),
            new Product(7, "Product 7", "San pham thu 7", 700, "Brand 7" ),
            new Product(8, "Product 8", "San pham thu 8", 800, "Brand 8" ),
            new Product(9, "Product 9", "San pham thu 9", 900, "Brand 9" ),
            new Product(10, "Product 10", "San pham thu 10", 1000, "Brand 10" ),
            new Product(11, "Product 11", "San pham thu 11", 1100, "Brand 11" ),
            new Product(12, "Product 12", "San pham thu 12", 1200, "Brand 12" ))
    );

    @GetMapping //GET: https://localhost:8080/products
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}") //GET: https://localhost:8080/products/1
    public Product getProductById(@PathVariable int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //Tìm kiếm 1 sản phẩm theo tên đầu tiên được tìm thấy
    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

}



