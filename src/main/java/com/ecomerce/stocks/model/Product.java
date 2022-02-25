package com.ecomerce.stocks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer productId;
    private String productName;
    private Brand brand;
    private Category category;
    private Integer quantity;
    private Integer price;
    private CustomerType customerType;
    private Boolean isDiscounted = false;
}
