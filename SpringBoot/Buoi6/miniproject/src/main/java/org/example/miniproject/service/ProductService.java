package org.example.miniproject.service;

import java.util.List;
import org.example.miniproject.model.Product;

public interface ProductService {

  List<Product> getAllProduct();

  Product findProductById(int id);

  List<Product> findProductByDescription(String keyword);


  List<Product> sortProductByPrice();

}
