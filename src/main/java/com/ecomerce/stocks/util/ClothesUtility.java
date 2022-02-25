package com.ecomerce.stocks.util;

import com.ecomerce.stocks.entity.ClothesEntity;
import com.ecomerce.stocks.model.Clothes;

import java.util.ArrayList;
import java.util.List;

public final class ClothesUtility {

   private ClothesUtility(){
    //Empty Constructor
   }
   public static List<Clothes> getClothesFromClothesEntities (List<ClothesEntity> clothesEntityList){
       // incomingList - INFO
       List<Clothes> clothesList = new ArrayList<>();
       for(ClothesEntity clothEntity: clothesEntityList){
           // Each Object - TRACE/DEBUG
           Clothes clothe = new Clothes(clothEntity.getClotheId(),clothEntity.getClotheName());
           clothesList.add(clothe);
       }
       // Outgoing List - INFO
       return clothesList;
   }

    public static List<Clothes> getClothesFromClothesEntitiesUsingJava8 (List<ClothesEntity> clothesEntityList){
        List<Clothes> clothesList = new ArrayList<>();
       clothesEntityList.parallelStream().forEach(clothesEntity -> {
           Clothes clothe = new Clothes(clothesEntity.getClotheId(),clothesEntity.getClotheName());
           clothesList.add(clothe);
       });
        return clothesList;
    }

}
