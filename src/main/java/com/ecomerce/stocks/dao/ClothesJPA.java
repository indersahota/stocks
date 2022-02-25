package com.ecomerce.stocks.dao;

import com.ecomerce.stocks.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesJPA extends JpaRepository<ClothesEntity, Integer> {
}

