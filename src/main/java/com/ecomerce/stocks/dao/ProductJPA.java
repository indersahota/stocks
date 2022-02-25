package com.ecomerce.stocks.dao;

import com.ecomerce.stocks.entity.ProductEntity;
import com.ecomerce.stocks.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJPA extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "SELECT * FROM product WHERE brand_id = ?", nativeQuery = true)
    List<ProductEntity> getByBrandId(Integer brandId);

    @Query(value = "Select * FROM product where  category_id = ? " , nativeQuery = true)
    List<ProductEntity> getByCategoryId(Integer categoryId);

    @Query(value = "Select * FROM product where  customer_type_id = ? " , nativeQuery = true)
    List<ProductEntity> getByCustomerTypeId(Integer customerTypeId);

    @Query(value = "Select * FROM product where  product_id IN (:productIds) " , nativeQuery = true)
    List<ProductEntity> getByProductIdIn(@Param("productIds") List<Integer> productIds);


    // List<ProductEntity> findByBrandId(Integer brandId);
}
