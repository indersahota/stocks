package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.BrandJPA;
import com.ecomerce.stocks.entity.BrandEntity;
import com.ecomerce.stocks.model.Brand;
import com.ecomerce.stocks.util.BrandUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public BrandServiceImpl implements  BrandService{

    @Autowired
    BrandJPA brandJPA;

    Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Override
    public String addBrand(Brand brand) {
        String result = "Brand not succesfuly added";
        try
        {
            BrandEntity brandEntity = BrandUtility.getBrandEntityFromBrand(brand);
            brandJPA.save(brandEntity);
            result = "Brand Successfully added with " + brand.getBrandId();
        }
        catch(Exception e)
        {
            logger.trace("Brand not successfully fetched");
            // Log the exceptions
            // But here we are printing to console
            // Inder --> To replace this print and log it using spring-boot or slf4j
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateBrand(Brand brand) {
        String result = "Brand not Updated";
        try
        {
            BrandEntity brandEntity = BrandUtility.getBrandEntityFromBrand(brand);
            brandJPA.save(brandEntity);
            result = "Brand Successfully updated with " + brand.getBrandId();
        }
        catch(Exception e)
        {
            // Log the exceptions
            // But here we are printing to console
            // Inder --> To replace this print and log it using spring-boot or slf4j
            e.printStackTrace();
        }
        return result;
    }

}
