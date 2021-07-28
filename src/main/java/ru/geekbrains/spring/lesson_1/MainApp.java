package ru.geekbrains.spring.lesson_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);
        consoleControl(productRepository, cart);

        context.close();

    }


    private static void consoleControl(ProductRepository productRepository, Cart cart) {
        Scanner scanner = new Scanner(System.in);




        System.out.println("Перед вами склад с продуктами: " + productRepository.findAll() + "\n");
        System.out.println("И ваша корзина: " + cart.lookAll() + "\n");

        while (true) {
            System.out.println("Какое действие вы хотите совершить? (1. Купить / 2. Продать ) Выберите цифру");
            int menuChose = scanner.nextInt();



            if (menuChose == 1) {
                System.out.println("Чтобы вы хотели добавить в корзину? (Введите id продукта из склада) ");
                Long productChose = 0L;
                try {
                    productChose = scanner.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Вы ввели не правильное значение, попробуйте ещё раз");
                }

                Optional<Product> product = productRepository.findById(productChose);
                if (product.isEmpty()) {
                    System.out.println("Продукт не найден");

                    //TODO КОД ДЛЯ ВЫХОДА
                    continue;
                }

                System.out.println("Вы положили в корзину: " + product.get().getTitle());
                cart.add(product.get());
                System.out.println("В вашей корзине лежат: " + cart.lookAll());


            } else if (menuChose == 2) {
                System.out.println("Чтобы вы хотели продать из корзины? (Введите id продукта) ");
                Long productRemoveChose = 0L;
                productRemoveChose = scanner.nextLong();
                cart.remove(productRemoveChose);
                System.out.println("В вашей корзине лежат: " + cart.lookAll());
            } else System.out.println("Ошибка! Введен не существующий пункт меню, попробуйте снова.");

        }

    }
}
