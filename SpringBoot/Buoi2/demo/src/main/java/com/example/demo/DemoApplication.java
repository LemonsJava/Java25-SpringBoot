package com.example.demo;

import com.example.demo.model.ClassRoom;
import com.example.demo.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context  = SpringApplication.run(DemoApplication.class, args);
		Student student = context.getBean(Student.class);
		System.out.println(student);

		ClassRoom classRoom = context.getBean(ClassRoom.class);
		System.out.println("ClassRoom: " + classRoom);

	}

}
