package com.company.company.homework7.src.main.java.ru.products;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.products");
        ProductRepository productRepo = context.getBean(ProductRepository.class);


    }
}
