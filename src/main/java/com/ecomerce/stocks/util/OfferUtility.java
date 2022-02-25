package com.ecomerce.stocks.util;

import com.ecomerce.stocks.entity.OffersEntity;
import com.ecomerce.stocks.model.Offers;

public final class OfferUtility {
    public static OffersEntity offersEntityFromOffer(Offers offers){
        if(offers == null)
            return null;
        OffersEntity offersEntity = new OffersEntity(offers.getOfferId(),offers.getOfferOnType(),offers.getOfferTypeValue(),offers.getDiscountPercentage());
        return offersEntity;
    }
}
