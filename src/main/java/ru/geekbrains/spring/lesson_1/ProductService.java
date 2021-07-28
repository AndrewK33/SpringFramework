package ru.geekbrains.spring.lesson_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    private ProductRepository productRepository;



    @Autowired
    public void setItemRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int getSumPrice() {
        return productRepository.findAll().stream().mapToInt(Product::getPrice).sum();
    }


    /*public Item findById(Long id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }

    public List<Item> findAll() {
        return items;
    }

    public void save(Item item) {
        Long newId = items.stream().mapToLong(Item::getId).max().getAsLong() + 1;
        item.setId(newId);
        items.add(item);
    }*/

}
