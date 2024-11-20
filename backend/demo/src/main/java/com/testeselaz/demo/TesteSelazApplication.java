package com.testeselaz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.testeselaz.demo", "com.todolist"})
public class TesteSelazApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteSelazApplication.class, args);
    }
}
