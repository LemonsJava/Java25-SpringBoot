package com.example.demo.util;

import com.example.demo.model.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class EXCELFileReader implements IFileReader {

  @Override
  public List<Book> readFile(String path) {
//    List<Book> books = new ArrayList<>();
//
//    try (InputStream inputStream = new FileInputStream(path);
//        Workbook workbook = new XSSFWorkbook(inputStream)) {
//
//      Sheet sheet = workbook.getSheetAt(0);
//      for (Row row : sheet) {
//        if (row.getRowNum() == 0) {
//          continue; // Bỏ qua dòng tiêu đề
//        }
//
//        Book book = new Book();
//        book.setTitle(row.getCell(0).getStringCellValue());
//        book.setAuthor(row.getCell(1).getStringCellValue());
//        book.setYear((int) row.getCell(2).getNumericCellValue());
//
//        books.add(book);
//      }
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return books;
    List<Book> books = new ArrayList<>();
    try {
      FileInputStream excelFile = new FileInputStream(path); //đọc file Excel từ đường dẫn path
      Workbook workbook = new XSSFWorkbook(excelFile);
      //Tạo một đối tượng Workbook từ file Excel. XSSFWorkbook là lớp để xử lý các file Excel có định dạng .xlsx.
      Sheet dataTypeSheet = workbook.getSheetAt(0);
      // Lấy sheet đầu tiên trong file Excel (vì chỉ số là 0). Biến dataTypeSheet đại diện cho sheet này.
      DataFormatter fmt = new DataFormatter();
      //Khởi tạo một đối tượng DataFormatter, cho phép bạn định dạng dữ liệu từ các ô trong Excel dưới dạng chuỗi, bất kể kiểu dữ liệu trong ô đó là gì (số, văn bản, ngày tháng, v.v.).
      Iterator<Row> iterator = dataTypeSheet.iterator();
      //Tạo một iterator để duyệt qua các hàng (row) trong sheet dataTypeSheet.
      Row firstRow = iterator.next();
      Cell firstCell = firstRow.getCell(0);
//      System.out.println(firstCell.getStringCellValue());
      while (iterator.hasNext()) {
        Row currRow = iterator.next();

        Book book = new Book();
        book.setId(Integer.parseInt(fmt.formatCellValue(currRow.getCell(0))));
        book.setTitle(fmt.formatCellValue(currRow.getCell(1)));
        book.setAuthor(fmt.formatCellValue(currRow.getCell(2)));
        book.setYear((int) currRow.getCell(3).getNumericCellValue());

        books.add(book);
      }
      workbook.close();
      excelFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return books;
  }
}
