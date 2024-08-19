package org.example.miniproject.util;

import java.util.List;
import org.example.miniproject.model.Product;

public interface IFileReader {

  List<Product> readFile(String path);

}
