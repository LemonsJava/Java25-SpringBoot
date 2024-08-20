package org.example.miniproject.dao.imlp;

import java.util.List;
import org.example.miniproject.dao.ProductDAO;
import org.example.miniproject.database.ProductDataBase;
import org.example.miniproject.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImlp implements ProductDAO {

  @Override
  public Product findById(int id) {
    return ProductDataBase.products.stream()
        .filter(product -> product.getId() == id)
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<Product> findAll() {
    return ProductDataBase.products;
  }

  @Override
  public List<Product> findByDescription(String keyword) {
    return ProductDataBase.products.stream()
        .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
        .toList();
  }

  @Override
  public List<Product> sortByPrice() {
    return ProductDataBase.products.stream()
        .sorted((p1, p2) -> (int) (p2.getPrice() - p1.getPrice()))
        .toList();
  }
}
