package com.ecomerce.stocks.util;

import com.ecomerce.stocks.entity.BrandEntity;
import com.ecomerce.stocks.model.Brand;

public final class BrandUtility {

    private BrandUtility(){

    }
    public static BrandEntity getBrandEntityFromBrand(Brand brand){
        if(brand == null)
            return null;
        BrandEntity brandEntity = new BrandEntity(brand.getBrandId(), brand.getBrandName());
        return brandEntity;
    }

    public static Brand getBrandFromBrandEntity(BrandEntity brandEntity){
        if(brandEntity == null)
            return null;
        Brand brand = new Brand(brandEntity.getBrandId(), brandEntity.getBrandName());
        return brand;
    }
}
