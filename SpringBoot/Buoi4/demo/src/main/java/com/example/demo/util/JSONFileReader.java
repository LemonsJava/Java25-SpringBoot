package com.example.demo.util;

import com.example.demo.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component // SD thu vien Jackson hoac GSON
public class JSONFileReader implements IFileReader {

  @Override
  public List<Book> readFile(String path) {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Book> books = new ArrayList<>();
    try {
      books = objectMapper.readValue(new File(path), new TypeReference<>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    return books;
  }
}
