package com.ecomerce.stocks.util;

import com.ecomerce.stocks.entity.BrandEntity;
import com.ecomerce.stocks.model.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class BrandUtilityTest {

    public static BrandEntity getBrandEntityFromBrand(Brand brand){
        if(brand == null)
            return null;
        BrandEntity brandEntity = new BrandEntity(brand.getBrandId(), brand.getBrandName());
        return brandEntity;
    }

    @Test
    public void testGetBrandEntityFromBrandWithNull() {
        BrandEntity result = BrandUtility.getBrandEntityFromBrand(null);
        Assert.isNull(result);
    }

    @Test
    public void testGetBrandEntityFromBrandWithoutNull() {
        BrandEntity result = BrandUtility.getBrandEntityFromBrand(new Brand());
        Assert.isTrue(result != null);
    }

    @Test
    public void testGetBrandEntityFromBrandWithValues() {
        BrandEntity result = BrandUtility.getBrandEntityFromBrand(new Brand(1, "CK"));
        Assert.isTrue(result.getBrandId().intValue() == 1);
        Assert.isTrue(result.getBrandName().equals("CK"));
    }
}
