package ru.geekbrains.spring.lesson_1;

import java.util.Objects;

public class CartItem {
    private int cartItemId;
    private Product product;
    private int count;

    public CartItem(int cartItemId, Product product, int count) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.count = count;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public void incrementCount() {
        this.count++;
    }
    public int decrementCount() {
        return --this.count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", product=" + product +
                ", count=" + count +
                '}';
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
