package com.example.demo.controller;

import com.example.demo.model.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@RestController
@Controller
@RequestMapping("/products")

public class ProductController {

  List<Product> products = new ArrayList<>(List.of(
      new Product(1, "Iphone 15 Pro Max", "Dien thoai Iphone 15 Pro Max", 100, "Apple"),
      new Product(2, "Samsung Galaxy S22", "Dien thoai Samsung Galaxy S22", 200, "Samsung"),
      new Product(3, "Xiaomi 11T", "Dien thoai Xiaomi 11T", 300, "Xiaomi"),
      new Product(4, "Canon EOS R5", "May anh Canon EOS R5", 400, "Canon"),
      new Product(5, "Macbook Pro", "May tinh Macbook Pro", 500, "Apple"),
      new Product(6, "Apple Watch", "Dong ho thong minh Apple Watch", 600, "Apple"),
      new Product(7, "Samsung Galaxy Watch", "Dong ho Samsung Galaxy Watch", 700, "Samsung"),
      new Product(8, "Sony PlayStation 5", "May console Sony PlayStation 5", 800, "Sony"),
      new Product(9, "Sony Alpha A7", "May anh Sony Alpha A7", 900, "Sony"),
      new Product(10, "Thinkbook 16", "May tinh Thinkbook 16", 1000, "Lenovo"),
      new Product(11, "Thinkpad X1", "May tinh Thinkpad X1", 1100, "Lenovo"),
      new Product(12, "Macbook Air", "May tinh Macbook Air", 1200, "Apple"))
  );

  @GetMapping //GET: https://localhost:8080/products
//    @ResponseBody //Du lieu tra ve cua method nam trong body cua response
//    @ResponseStatus(HttpStatus.OK)
//    public List<Product> getAllProducts() {
//        return products;
//    }

  public ResponseEntity<List<Product>> getAllProducts() {
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/{id}") //GET: https://localhost:8080/products/1
//    public Product getProductById(@PathVariable int id) {
//        return products.stream()
//                .filter(product -> product.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }

  public ResponseEntity<Product> getProductById(@PathVariable int id) {
    return products.stream()
        .filter(product -> product.getId() == id)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .findFirst()
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

//        for (Product product : products) {
//            if (product.getId() == id) {
//                return new ResponseEntity<>(product, HttpStatus.OK); //OK
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //Not found : 404
  }

  //Tìm kiếm 1 sản phẩm theo tên đầu tiên được tìm thấy
  @GetMapping("/name/{name}") //
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED) //201
  public Product getProductByName(@PathVariable String name) {
    return products.stream()
        .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
        .findFirst()
        .orElse(null);
  }

//    2. Lấy sản phẩm với tên bắt đầu bằng prefix nào đó
//    API: GET /products/name-starts/{prefix}
//    Mô tả: Trả về danh sách sản phẩm có tên bắt đầu bằng nào đó.

  @GetMapping("/name-starts/{prefix}") //GET: https://localhost:8080/products/name-starts/i
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED) //201
//    public List<Product> getProductByNameStartsWith(@PathVariable String prefix) {
//        return products.stream()
//                .filter(product -> product.getName().toLowerCase().startsWith(prefix.toLowerCase()))
//                .toList();
//    }
  public ResponseEntity<List<Product>> getProductByNameStartsWith(@PathVariable String prefix) {
    return new ResponseEntity<>(products.stream()
        .filter(product -> product.getName().toLowerCase().startsWith(prefix.toLowerCase()))
        .collect(Collectors.toList()), HttpStatus.OK);
  }

  //    3. Lọc sản phẩm theo khoảng giá
//    API: GET /products/price/{min}/{max}
//    Mô tả: Trả về danh sách sản phẩm có giá nằm trong khoảng từ min đến max.
  @GetMapping("/price/{min}/{max}") //GET: https://localhost:8080/products/price/100/500
  public ResponseEntity<List<Product>> getProductByPrice(@PathVariable int min,
      @PathVariable int max) {
    return new ResponseEntity<>(products.stream()
        .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
        .collect(Collectors.toList()), HttpStatus.OK);
  }

  //  4. Lấy sản phẩm theo thương hiệu
//  API: GET /products/brand/{brand}
//  Mô tả: Trả về danh sách sản phẩm thuộc thương hiệu được chỉ định.
  @GetMapping("/brand/{brand}") //GET: https://localhost:8080/products/brand/Apple
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED) //201
  public List<Product> getProductByBrand(@PathVariable String brand) {
    return products.stream()
        .filter(product -> product.getBrand().equals(brand))
        .toList();
  }
//  5. Lấy sản phẩm có giá cao nhất
//  API: GET /products/brand/{brand}/max-price
//  Mô tả: Trả về sản phẩm có giá cao nhất theo brand được chỉ định.

  @GetMapping("/brand/{brand}/max-price")
  //GET: https://localhost:8080/products/brand/Apple/max-price
//  @ResponseBody
//  @ResponseStatus(HttpStatus.CREATED) //201
//  public List<Product> getProductByBrandAndMaxPrice(@PathVariable String brand,
//      @RequestParam int maxPrice) {
//    return products.stream()
//        .filter(product -> product.getBrand().equals(brand) && product.getPrice() <= maxPrice)
//        .toList();
//  }

  public ResponseEntity<List<Product>> getProductsByBrandAndMaxPrice(@PathVariable String brand) {
    return new ResponseEntity<>(products.stream()
        .filter(product -> product.getBrand().equals(brand))
        .sorted(Comparator.comparingInt(Product::getPrice).reversed())
        .limit(1)
        .collect(Collectors.toList()), HttpStatus.OK);
  }

}



