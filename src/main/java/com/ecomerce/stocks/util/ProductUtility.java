package com.ecomerce.stocks.util;

import com.ecomerce.stocks.entity.ProductEntity;
import com.ecomerce.stocks.library.CustomerTypeLibrary;
import com.ecomerce.stocks.model.CustomerType;
import com.ecomerce.stocks.model.CustomerTypeEnum;
import com.ecomerce.stocks.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ProductUtility {

    private static Map<Integer, CustomerTypeEnum> ID_TO_CUSTOMER_TYPE_ENUM = CustomerTypeLibrary.ID_TO_CUSTOMER_TYPE_ENUM;

    public static Product getProductFromProductEntity(ProductEntity productEntity){
        if(productEntity == null)
            return null;

        Integer customerTypeId = productEntity.getCustomerTypeId();
        CustomerType customerType = new CustomerType(customerTypeId, ID_TO_CUSTOMER_TYPE_ENUM.get(customerTypeId));

        Product product = new Product(productEntity.getProductId(),
                                      productEntity.getProductName(),
                                      BrandUtility.getBrandFromBrandEntity(productEntity.getBrandEntity()),
                                      CategoryUtility.getCategoryFromCategoryEntity(productEntity.getCategoryEntity()),
                                      productEntity.getQuantity(),
                                      productEntity.getPrice(),
                                      customerType ,
                            false);

           return product;
    }
    public static List<Product> getListOfProductsFromProductEntities(List<ProductEntity> productEntities){
        List<Product> productList = new ArrayList<>();
        if(productEntities == null)
            return productList;
        productEntities.forEach(productEntity -> {
            Product product = getProductFromProductEntity(productEntity);
            productList.add(product);
        });
        return productList;
    }

    public static List<Product> getProductsByBrand(List<Product> productList, String discountedBrand) {
        List<Product> specificBrandProducts = new ArrayList<>();
        productList.forEach(product -> {
            if(discountedBrand.equalsIgnoreCase(product.getBrand().getBrandName()))
            {
                specificBrandProducts.add(product);
            }
        });
        return specificBrandProducts;
    }

    public static List<Product> getProductsNotByBrand(List<Product> productList, String discountedBrand) {
        List<Product> specificBrandProducts = new ArrayList<>();
        productList.forEach(product -> {
            if(!discountedBrand.equalsIgnoreCase(product.getBrand().getBrandName()))
            {
                specificBrandProducts.add(product);
            }
        });
        return specificBrandProducts;
    }
}
