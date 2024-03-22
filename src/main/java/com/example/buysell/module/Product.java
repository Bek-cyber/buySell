package com.example.buysell.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Product {
    private Long id;

    private String title;

    private String description;

    private int price;

    private String city;

    private String author;
}
