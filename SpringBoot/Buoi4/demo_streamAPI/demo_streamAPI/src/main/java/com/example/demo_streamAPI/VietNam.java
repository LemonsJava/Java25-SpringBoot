package com.example.demo_streamAPI;

public class VietNam implements IGreeting {
  @Override
  public void sayHello(String name) {
    System.out.println("Xin chao "+ name);
  }

}
