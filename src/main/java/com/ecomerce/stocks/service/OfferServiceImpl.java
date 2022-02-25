package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.OfferJPA;
import com.ecomerce.stocks.entity.CategoryEntity;
import com.ecomerce.stocks.entity.OffersEntity;
import com.ecomerce.stocks.model.Offers;
import com.ecomerce.stocks.util.CategoryUtility;
import com.ecomerce.stocks.util.OfferUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService{
    @Autowired
    OfferJPA offerJPA;

    Logger logger = LoggerFactory.getLogger(OfferServiceImpl.class);

    @Override
    public String addOffer(Offers offers) {
        String result = "Offer not added";
        try
        {
            OffersEntity offersEntity = OfferUtility.offersEntityFromOffer(offers);
            offerJPA.save(offersEntity);
            result = "Offer added successfully with offer ID" + offers.getOfferId();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateOffer(Offers offers) {
        String result = "Offer not updated";
        try
        {
            OffersEntity offersEntity = OfferUtility.offersEntityFromOffer(offers);
            offerJPA.save(offersEntity);
            result = "Offer updated successfully with offer ID" + offers.getOfferId();
        }
        catch(Exception e)
        {
            logger.trace("Offer not successfully added ");
        }
        return result;
    }
}
