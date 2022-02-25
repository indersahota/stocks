package com.ecomerce.stocks.service;

import com.ecomerce.stocks.exception.ProductNotFoundException;
import com.ecomerce.stocks.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public List<Product> getAllProductsByBrandId(Integer brandId);

    public List<Product> getAllProductsByBrandName(String brandName);

    List<Product> getAllProductsByCategoryId(Integer categoryId);

    List<Product> getAllProductsByCustomerType(String customerType) throws Exception;
}
