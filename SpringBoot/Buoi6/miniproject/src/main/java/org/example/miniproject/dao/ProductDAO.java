package org.example.miniproject.dao;

import java.util.List;
import org.example.miniproject.model.Product;

public interface ProductDAO {

  Product findById(int id);

  List<Product> findAll();

  List<Product> findByDescription(String keyword);

  List<Product> sortByPrice();

}
