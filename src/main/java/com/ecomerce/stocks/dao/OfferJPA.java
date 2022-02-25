package com.ecomerce.stocks.dao;

import com.ecomerce.stocks.entity.OffersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferJPA extends JpaRepository<OffersEntity, Integer> {
}
