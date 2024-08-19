package org.example.miniproject.controller;

import java.util.List;
import org.example.miniproject.model.IPageResponse;
import org.example.miniproject.model.Product;
import org.example.miniproject.model.imlp.PageResponseImlp;
import org.example.miniproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

  @Autowired
  private ProductService productService;

  //Lay tat ca danh dach sp http://localhost:8080/products
  @GetMapping("/products")
  public String getAllProduct(@RequestParam(required = false, defaultValue = "1") int page,
      @RequestParam(required = false, defaultValue = "12") int size,
      Model model) {
    IPageResponse<Product> pageResponse = PageResponseImlp.<Product>builder()
        .currentPage(page)
        .pageSize(size)
        .content(productService.getAllProduct())
        .build();
    model.addAttribute("products", pageResponse);
    return "index";
  }

  //Lay thong tin sp theo ID http://localhost:8080/products/1
  @GetMapping("/products/{id}")
  public String findProductById(Model model, @PathVariable int id) {
    model.addAttribute("product", productService.findProductById(id));
    return "productDetail";
  }

  //Tim kiem sp theo mo ta -> http://localhost:8080/products/search?keyword=abc
  @GetMapping("/products/search")
  public String findProductByDescription(Model model,
      @RequestParam(required = false) String keyword) {
    List<Product> listProduct;
    if (keyword != null) {
      listProduct = productService.findProductByDescription(keyword);
    } else {
      listProduct = productService.getAllProduct();
    }

    model.addAttribute("products", listProduct);
    return "searchResult";
  }

  //Sap xep sp theo gia giam dan -> http://localhost:8080/products/sortByPriceDesc
  @GetMapping("/products/sortByPriceDesc")
  public String sortProductByPrice(@RequestParam(required = false, defaultValue = "1") int page,
      @RequestParam(required = false, defaultValue = "12") int size,
      Model model) {
    IPageResponse<Product> pageResponse = PageResponseImlp.<Product>builder()
        .currentPage(page)
        .pageSize(size)
        .content(productService.sortProductByPrice())
        .build();
    model.addAttribute("sortedByPriceDesc", pageResponse);
    return "sortByPriceDesc";
  }
}
