package com.ecomerce.stocks.controller;

import com.ecomerce.stocks.model.Offers;
import com.ecomerce.stocks.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "offers")
public class OffersController {

    @Autowired
    OfferService offerService;

    @PostMapping(value="/add" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addOffer(@RequestBody Offers offers){
        return offerService.addOffer(offers);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateOffer(@RequestBody Offers offers){
        return offerService.updateOffer(offers);
    }
}
