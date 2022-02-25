package com.ecomerce.stocks.controller;


import com.ecomerce.stocks.model.Product;
import com.ecomerce.stocks.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    CartService  cartService;

    @GetMapping("/cartProductsForUser")
    public List<Product>  getCartProductForUser(@RequestParam Integer userId){
        return cartService.getProductsForUser(userId);

    }

}
