package com.ecomerce.stocks.dao;

import com.ecomerce.stocks.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJPA extends JpaRepository<CategoryEntity,Integer> {
}
