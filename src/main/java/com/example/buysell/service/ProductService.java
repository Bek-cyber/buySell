package com.example.buysell.service;

import com.example.buysell.model.Product;
import com.example.buysell.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getList(String title) {
        log.info("Try to find products by title: {}", title);
        List<Product> products=  new ArrayList<>();
        if (title != null) {
            products = repository.findByTitle(title);
        }
        else {
            products = repository.findAll();
        }
        return products;
    }

    public void saveProduct(Product product) {
        log.info("Try to save product: {}", product);
        repository.save(product);
    }

    public void removeProductList(Long id) {
        log.info("Try to remove product with id: {}", id);
        repository.deleteById(id);
    }

    public Product getProductById(Long id) {
        log.info("Try to find product with id: {}", id);
        return repository.findById(id).orElse(null);
    }
}
