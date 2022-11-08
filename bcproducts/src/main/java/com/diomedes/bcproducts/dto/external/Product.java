package com.diomedes.bcproducts.dto.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
}
