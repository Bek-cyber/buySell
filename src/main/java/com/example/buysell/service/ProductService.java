package com.example.buysell.service;

import com.example.buysell.module.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList = new ArrayList<>();
    private long ID = 0;

    {
        productList.add(Product.builder()
                .id(++ID)
                .title("title1")
                .description("desc1")
                .price(1)
                .author("author1")
                .city("city1")
                .build()
        );
        productList.add(Product.builder()
                .id(++ID)
                .title("title2")
                .description("desc2")
                .price(2)
                .author("author2")
                .city("city2")
                .build()
        );
    }

    public List<Product> getList() {
        return productList;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        productList.add(product);
    }

    public void removeProductList(Long id) {
        productList.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
