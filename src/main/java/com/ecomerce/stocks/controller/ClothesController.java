package com.ecomerce.stocks.controller;

import com.ecomerce.stocks.model.Clothes;
import com.ecomerce.stocks.service.ClothesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {
    private static Logger logger = LoggerFactory.getLogger(ClothesController.class);

    @Autowired
    private ClothesService clothesService;

    @GetMapping("/getall")
    public List<Clothes> getListOfClothes()
    {
        logger.info("Received the request to get all clothes");

        List<Clothes> clothesList =  clothesService.getAllClothes();
        logger.info("Returning response with clothes: " + clothesList);

        return clothesList;
    }

}
