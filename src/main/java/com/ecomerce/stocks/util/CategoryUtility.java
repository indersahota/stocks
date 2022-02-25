package com.ecomerce.stocks.util;

import com.ecomerce.stocks.entity.CategoryEntity;
import com.ecomerce.stocks.model.Category;

public final class CategoryUtility {
    public static CategoryEntity CategoryEntityFromCategory(Category category){
        if(category ==  null)
            return null;
        CategoryEntity categoryEntity = new CategoryEntity(category.getCategoryID(),category.getCategoryName());
        return categoryEntity;
    }

    public static Category getCategoryFromCategoryEntity(CategoryEntity categoryEntity) {
        if(categoryEntity ==  null)
            return null;
        Category category = new Category(categoryEntity.getCategoryId(),categoryEntity.getCategoryTypeName());
        return category;

    }
}
