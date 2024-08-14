package com.example.demo.util;

import com.example.demo.model.Book;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
//Su dung thu vien OpenCSV
public class CSVFileReader implements IFileReader {


  @Override
  public List<Book> readFile(String path) {
    try {
      Reader reader = new FileReader(path);
      CsvToBean<Book> builder = new CsvToBeanBuilder<Book>(reader)
          .withType(Book.class)
          .withIgnoreLeadingWhiteSpace(true)
          .build();

      return builder.parse();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  //CsvToBeanBuilder<Book>(reader): Khởi tạo một đối tượng CsvToBeanBuilder để cấu hình cách đọc file CSV và ánh xạ dữ liệu từ CSV vào các đối tượng Book.
  // Đối tượng này được xây dựng bằng cách truyền vào reader, tức là đối tượng Reader đã mở ở bước trước.

  //withType(Book.class): Chỉ định kiểu đối tượng (Book) mà dữ liệu CSV sẽ được ánh xạ vào.
  //Điều này yêu cầu lớp Book phải có các thuộc tính và/hoặc chú thích (@annotations) tương ứng với các cột trong CSV.

  //withIgnoreLeadingWhiteSpace(true): Cấu hình để bỏ qua khoảng trắng ở đầu các giá trị trong file CSV.
  //Điều này giúp tránh các lỗi không mong muốn do khoảng trắng.

  //build(): Hoàn thành việc cấu hình và trả về một đối tượng CsvToBean<Book>, được sử dụng để thực hiện quá trình phân tích cú pháp (parsing) CSV thành các đối tượng Book.
}
