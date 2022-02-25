package com.ecomerce.stocks.controller;

import com.ecomerce.stocks.model.Category;
import com.ecomerce.stocks.service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;

    @PostMapping(value = "add" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public  String addCategory(@RequestBody Category category){
        return categoryServices.addCategory(category);
    }

    @PutMapping(value = "/update" , consumes = MediaType.APPLICATION_JSON_VALUE)


    public String updateCategory(@RequestBody Category category){
        return categoryServices.updateCategory(category);
    }
}
