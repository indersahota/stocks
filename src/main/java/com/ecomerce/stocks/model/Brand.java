package com.ecomerce.stocks.model;

import lombok.*;

// Brand
// Category
// CustomerType - No Entity
// Offer
// Product
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private Integer brandId;
    private String brandName;
}
