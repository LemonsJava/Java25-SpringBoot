package com.example.demo.database;

import com.example.demo.util.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements CommandLineRunner {

  @Autowired
  @Qualifier("CSVFileReader")
  private IFileReader fileReader;


  @Override
  public void run(String... args) {
    System.out.println("Doc du lieu tu file");
    BookDB.books = fileReader.readFile("books.csv");
    System.out.println("Tong so sach trong file la: " + BookDB.books.size());
  }
}
