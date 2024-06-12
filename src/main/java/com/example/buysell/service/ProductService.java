package com.example.buysell.service;

import com.example.buysell.model.Image;
import com.example.buysell.model.Product;
import com.example.buysell.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getList(String title) {
        log.info("Try to find products by title: {}", title);
        List<Product> products = new ArrayList<>();
        if (title != null) {
            products = repository.findByTitle(title);
        } else {
            products = repository.findAll();
        }
        return products;
    }

    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1 != null && file1.getSize() > 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2 != null && file2.getSize() > 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3 != null && file3.getSize() > 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("Try to save product. title: {}; author: {}", product.getTitle(), product.getAuthor());
        Product saved = repository.save(product);
        saved.setPreviewImageId(saved.getImages().get(0).getId());
        repository.save(saved);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {

        return Image.builder()
                .name(file.getName())
                .originalFileName(file.getContentType())
                .bytes(file.getBytes())
                .contentType(file.getContentType())
                .size(file.getSize())
                .build();
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
