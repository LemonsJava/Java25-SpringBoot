package org.example.miniproject.service.imlp;

import java.util.List;
import org.example.miniproject.dao.ProductDAO;
import org.example.miniproject.model.Product;
import org.example.miniproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImlp implements ProductService {

  @Autowired
  private ProductDAO productDAO;

  @Override
  public List<Product> getAllProduct() {
    return productDAO.findAll();
  }

  @Override
  public Product findProductById(int id) {
    return productDAO.findById(id);
  }

  @Override
  public List<Product> findProductByDescription(String keyword) {
    return productDAO.findByDescription(keyword);
  }

  @Override
  public List<Product> sortProductByPrice() {
    return productDAO.sortByPrice();
  }

}
