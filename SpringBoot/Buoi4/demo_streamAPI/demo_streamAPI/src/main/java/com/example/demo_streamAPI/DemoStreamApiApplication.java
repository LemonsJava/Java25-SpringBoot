package com.example.demo_streamAPI;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoStreamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStreamApiApplication.class, args);

		//Cach 1: Su dung class implements
		IGreeting vietNam = new VietNam();
		vietNam.sayHello("LemonS");


		//Cach 2: Su dung Anonymous class
		IGreeting english = new IGreeting() {
			@Override
			public void sayHello(String name) {
				System.out.println("Hello "+ name);
			}
		};
		english.sayHello("LemonS");

		//Cach 3: Su dung lambda expression
		IGreeting chinese = (name) -> System.out.println("你好 "+ name);
		chinese.sayHello("LemonS");


		//Caculator sum of 2 numbers
		ICaculator sum = (a, b) -> a + b; //Lambda expression: ICaculator sum = Integer::sum
		System.out.println(sum.calculate(5, 7));

		List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		nums.forEach(num -> System.out.println(num)); //Lambda expression: nums.forEach(System.out::println);
		nums.removeIf(num -> num % 2 == 1);
		System.out.println(nums);
		nums.sort((a, b) -> a - b);


		//Thao tac voi stream API
		int total = nums.stream()
				.map(num -> 2 * num)
				.reduce(0, Integer::sum);
		System.out.println("Tong bang: " + total);

		int maxOdd = nums.stream()
				.filter(num -> num % 2 == 1)
				.max((a, b) -> a - b)
				.orElse(0);
		System.out.println("So le lon nhat: " + maxOdd);


		List<Integer> nums2 = new ArrayList<>(List.of(10, 5, 3, 12, 6, 7, 5, 3));
		System.out.println(nums2);
//Lấy danh sách các phần tử không trùng nhau
		nums2.stream()
				.distinct()
				.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");
//Lấy 5 phần tử đầu tiên trong mảng
		nums2.stream()
				.limit(5)
				.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

//Lấy phần tử từ thứ 3 -> thứ 5
		nums2.stream()
				.skip(2)
				.limit(3)
				.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

//Lấy phần tử đầu tiên > 5
		 int firstGreaterThan5 = nums2.stream()
				.skip(1)
				.filter(num -> num > 5)
				.findFirst()
				.orElse(0);
		System.out.println(firstGreaterThan5);
		System.out.println("\n");

//Kiểm tra xem list có phải là list chẵn hay không
		boolean check =nums2.stream()
				.allMatch(num -> num % 2 == 0);
		System.out.println(check);

//Kiểm tra xem list có phần tử > 10 hay không
		boolean check2 = nums2.stream()
				.anyMatch(num -> num > 10);
		System.out.println(check2);

//Có bao nhiêu phần tử > 5
		long count = nums2.stream()
				.filter(num -> num > 5)
				.count();

//Nhân đôi các phần tủ trong list và trả về list mới
		nums2.stream()
				.map(num -> num * 2)
				.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

//Kiểm tra xem list không chứa giá trị nào = 8 hay không
		boolean check3 = nums2.stream()
				.noneMatch(num -> num == 8);
		System.out.println(check3);

	}

}
