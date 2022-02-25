package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.BrandJPA;
import com.ecomerce.stocks.entity.BrandEntity;
import com.ecomerce.stocks.model.Brand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.util.Assert;



public class BrandServiceTest {


    private BrandServiceImpl objUnderTest;

    @Mock
    BrandJPA brandJPA;

    @BeforeEach
    public void  setup(){
        objUnderTest = new BrandServiceImpl();
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void addBrandTest() {

        Brand brand = new Brand(1, "CK");

        Mockito.when(brandJPA.save(Matchers.any(BrandEntity.class))).thenReturn(null);

        String result = objUnderTest.addBrand(brand);
        String expectedResult = "Brand Successfully added with 1";
        Assert.isTrue(expectedResult.equals(result));
    }
}
