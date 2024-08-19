package org.example.miniproject.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.example.miniproject.model.Product;
import org.springframework.stereotype.Component;

@Component
public class JSONFileReader implements IFileReader {

  @Override
  public List<Product> readFile(String path) {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Product> products = new ArrayList<>();
    try {
      products = objectMapper.readValue(new File(path), new TypeReference<>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    return products;
  }

}
