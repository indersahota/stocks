package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.CartJPA;
import com.ecomerce.stocks.dao.ProductJPA;
import com.ecomerce.stocks.entity.CartEntity;
import com.ecomerce.stocks.model.Product;
import com.ecomerce.stocks.util.ProductUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements  CartService{

    @Autowired
    ProductJPA productJPA;

    @Autowired
    CartJPA  cartJPA;

    public List<Product> getProductsForUser(Integer userId) {
        Optional<CartEntity> cartEntityOptional = cartJPA.findById(userId);
        if(cartEntityOptional.isPresent()){
            CartEntity cartEntity = cartEntityOptional.get();
            String prductIdStr = cartEntity.getProductId();
            String[] productIdArray = prductIdStr.split(";");
          //  List<String> productIdList = Arrays.asList(productIdArray);
            List<Integer> productIdList = new ArrayList<>();
            Arrays.stream(productIdArray).forEach(productId -> {
                Integer productIdInt = Integer.parseInt(productId);
                productIdList.add(productIdInt);
            });
            return ProductUtility.getListOfProductsFromProductEntities(productJPA.getByProductIdIn(productIdList));
        }
        return null;
    }
}
