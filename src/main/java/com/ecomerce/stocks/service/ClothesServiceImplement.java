package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.ClothesJPA;
import com.ecomerce.stocks.entity.ClothesEntity;
import com.ecomerce.stocks.model.Clothes;
import com.ecomerce.stocks.util.ClothesUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClothesServiceImplement implements ClothesService{

    @Autowired
    private ClothesJPA clothesJPA;

    @Override
    public List<Clothes> getAllClothes() {
        //
        List<ClothesEntity> clothesEntityList = clothesJPA.findAll();
        //
        return ClothesUtility.getClothesFromClothesEntities(clothesEntityList);

    }
}
