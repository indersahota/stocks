package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.CategoryJPA;
import com.ecomerce.stocks.entity.BrandEntity;
import com.ecomerce.stocks.entity.CategoryEntity;
import com.ecomerce.stocks.model.Category;
import com.ecomerce.stocks.util.BrandUtility;
import com.ecomerce.stocks.util.CategoryUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryServices {
    @Autowired
    CategoryJPA categoryJPA;

    Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public String addCategory(Category category) {
        String result = "Category not added";
        try
        {
            CategoryEntity categoryEntity = CategoryUtility.CategoryEntityFromCategory(category);
            categoryJPA.save(categoryEntity);
            result = "category added successfully with  category Id" + category.getCategoryID();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateCategory(Category category) {
        String result = "Category not updated";
        try
        {
            CategoryEntity categoryEntity = CategoryUtility.CategoryEntityFromCategory(category);
            categoryJPA.save(categoryEntity);
            result = "category updated successfully with  category Id" + category.getCategoryID();
        }
        catch(Exception e)
        {
            logger.trace("Category not successfully fetched");
        }
        return result;
    }
}
