package com.ecomerce.stocks.dao;

import com.ecomerce.stocks.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJPA extends JpaRepository<CartEntity,Integer> {
}
