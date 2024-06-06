package com.example.buysell.controller;

import com.example.buysell.model.Product;
import com.example.buysell.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", service.getList(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", service.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        service.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("product/remove/{id}")
    public String removeProduct(@PathVariable Long id) {
        service.removeProductList(id);
        return  "redirect:/";
    }
}
