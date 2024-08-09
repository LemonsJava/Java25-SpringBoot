package com.example.demo;

import com.example.demo.model.Book;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		Faker faker = new Faker();
		System.out.println(faker.name().fullName());


		Book book = new Book();
		book.setId(1);
		book.setTitle("Book 1");

		// Khoi tao doi tuong book2 su dung Builder

		Book book2 = Book.builder()
				.id(2)
                .title("Book 2")
                .author(faker.name().fullName())
                .build();

        System.out.println(book2);


	}

}
