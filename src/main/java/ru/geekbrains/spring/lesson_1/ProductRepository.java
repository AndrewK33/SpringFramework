package ru.geekbrains.spring.lesson_1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> productRepositoryList;


    @PostConstruct
    public void init() {
        productRepositoryList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 15),
                new Product(2L, "Milk", 25),
                new Product(3L, "Apple", 5),
                new Product(4L, "Fish", 30),
                new Product(5L, "Meat", 40)

        ));
    }

    public Optional<Product> findById(Long id) {
        return productRepositoryList.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public List<Product> findAll() {
        return productRepositoryList;
    }



}
