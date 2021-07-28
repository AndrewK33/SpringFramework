package ru.geekbrains.spring.lesson_1;


class CartTest {


    public static void main(String[] args) {

        Product product = new Product();
        product.setId(1);

        Cart cart = new Cart();

        cart.add(product);

        cart.remove(1);
    }
}