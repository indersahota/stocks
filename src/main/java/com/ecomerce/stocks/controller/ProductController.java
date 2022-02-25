package com.ecomerce.stocks.controller;

import com.ecomerce.stocks.model.Product;
import com.ecomerce.stocks.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getall")
    public List<Product> getAllProducts(){

         return productService.getAllProducts();
    }

    @GetMapping("/getByBrandId")
    public List<Product> getAllProductsByBrandId(@RequestParam Integer brandId){

        return productService.getAllProductsByBrandId(brandId);
    }

    @GetMapping("/getByBrandName")
    public List<Product> getAllProductsByBrandId(@RequestParam String brandName){

        return productService.getAllProductsByBrandName(brandName);
    }

    @GetMapping("/byCategoryId")
    public List<Product> getAllProductsByCategoryId(@RequestParam Integer categoryId){
        return productService.getAllProductsByCategoryId(categoryId);
    }

    @GetMapping("/byCustomerType")
    public List<Product> getAllProductsByCustomerType(@RequestParam String customerType) {
        try {
            return productService.getAllProductsByCustomerType(customerType);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }


}
