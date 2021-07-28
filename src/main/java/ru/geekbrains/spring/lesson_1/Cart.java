package ru.geekbrains.spring.lesson_1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Продукт 1 колво - 2
 * Продукт 3 колво - 1
 * Продукт 4 колво - 1
 */
@Component
@Scope("prototype")
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    private int sequence = 0;

    public void add(Product product) {
        //найти в корзине айтем продукта
        //если он есть увеличить count
        //если нету создать новый айтем и положить в корзину

        Optional<CartItem> cartItemOptional = cartItems.stream().filter(cartItem -> cartItem.getProduct().getId().equals(product.getId())).findAny();
        if (cartItemOptional.isEmpty()) {
            CartItem newItem = new CartItem(sequence++, product, 1);
            cartItems.add(newItem);
        } else {
            cartItemOptional.get().incrementCount();
        }
    }

    public void remove(long productId) {
        Optional<CartItem> cartItemOptional = cartItems.stream().filter(ci -> ci.getProduct().getId().equals(productId)).findAny();

        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            if (0 == cartItem.decrementCount()) {
                cartItems.remove(cartItem);
            }
        }


    }


    public List<Product> lookAllProducts() {
        return cartItems.stream().map(CartItem::getProduct).collect(Collectors.toList());
    }

    public List<CartItem> lookAll() {
        return cartItems;
    }

}
