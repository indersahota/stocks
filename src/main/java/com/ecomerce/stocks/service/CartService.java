package com.ecomerce.stocks.service;

import com.ecomerce.stocks.model.Product;

import java.util.List;

public interface CartService {
    List<Product> getProductsForUser(Integer userId);
}
