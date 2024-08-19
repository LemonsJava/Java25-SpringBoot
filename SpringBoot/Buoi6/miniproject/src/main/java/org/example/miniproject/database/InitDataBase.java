package org.example.miniproject.database;

import org.example.miniproject.util.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataBase implements CommandLineRunner {

  @Autowired
  private IFileReader fileReader;

  @Override
  public void run(String... args) throws Exception {
    ProductDataBase.products = fileReader.readFile("ProductDB.json");
    System.out.println("Tong so sp: " + ProductDataBase.products.size());
  }
}
