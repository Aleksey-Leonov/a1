package com.company.company.homework7.src.main.java.ru.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;


@Component
public class ProductRepository {
    public static List<Product> productList = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String b;

    @Bean
    public void addProductRepository() throws IOException {
        for (int i = 1; i <= 5; i++) {
            productList.add(new Product(i, "product" + i, 100 * i));
        }
        printMenu();
        while (true) {

            b = reader.readLine();
            logicMenu();

        }

    }

    void printMenu() {
        System.out.println("Введите команду из меню, чтобы совершить действие:");
        System.out.println("1) Показать всю корзину - /cart");
        System.out.println("2) Показать товар по id - /idOne");
        System.out.println("3) Добавить товар - /addProd");
        System.out.println("4) Удалить товар - /idDelete");
        System.out.println();
    }


    void logicMenu() throws IOException {
        if (b.equals("/cart")) {
            for (int i = 0; i < productList.size(); i++) {
                System.out.print("id - " + productList.get(i).getId() + "| ");
                System.out.print("name - " + productList.get(i).getName() + "| ");
                System.out.print("Price - " + productList.get(i).getPrice() + "| ");
                System.out.println();
            }
            System.out.println();
        } else if (b.equals("/idOne")) {
            System.out.println("введите id товара");
            boolean isA = true;
            while (true) {
                int a = Integer.parseInt(reader.readLine());
                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getId() == a) {
                        System.out.print("id - " + productList.get(i).getId() + "| ");
                        System.out.print("name - " + productList.get(i).getName() + "| ");
                        System.out.print("Price - " + productList.get(i).getPrice() + "| ");
                        System.out.println();
                        isA = false;
                        return;
                    } else if (a == -1) {
                        printMenu();
                        return;
                    }
                }
                if (isA = true) {
                    System.out.println("Такого товара не существует, введите существующий id или введите -1, чтобы перейти к меню");
                }
            }
        } else if (b.equals("/addProd")) {
            int id;
            String name;
            double price;
            System.out.println("Введите id товара");
            id = Integer.parseInt(reader.readLine());
            System.out.println("Введите name товара");
            name = reader.readLine();
            System.out.println("Введите цену товара");
            price = Double.parseDouble(reader.readLine());

            productList.add(new Product(id, name, price));
            System.out.println("Товар успешно добавлен");
        }
        else if (b.equals("/idDelete")) {
            System.out.println("Введите id товара для удаления");
            int a = Integer.parseInt(reader.readLine());
            for (int i = 0; i < productList.size(); i++) {
                if(a == productList.get(i).getId()){
                    productList.remove(i);
                    System.out.println("Товар удален");
                }
            }
        }
        else {
            System.out.println("Вы ввели несуществующую команду");
        }
    }
}
