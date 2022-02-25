package com.ecomerce.stocks.dao;

import com.ecomerce.stocks.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJPA extends JpaRepository<BrandEntity,Integer> {

    @Query(value = "SELECT * FROM brands WHERE brand_name = ?", nativeQuery = true)
    BrandEntity getByBrandName(String brandName);
}
