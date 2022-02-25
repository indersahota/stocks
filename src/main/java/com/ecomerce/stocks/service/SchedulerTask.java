package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.ProductJPA;
import com.ecomerce.stocks.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class SchedulerTask {

    @Autowired
    ProductJPA productJPA;


    @Autowired
    private MailService mailService;

    private static final String MAIL_TO = "beancoderoj@gmail.com,indersahota112@gmail.com";

    @Scheduled(fixedDelay = 9000)
    public void checkProductQuantityAndSendMail()
    {
        List<ProductEntity> productEntityList = new ArrayList<>();
        List<ProductEntity> productEntityListWithLessQuantity = new ArrayList<>();
        productEntityList = productJPA.findAll();

        productEntityList.forEach(productEntity -> {
            if(productEntity.getQuantity()<2)
                productEntityListWithLessQuantity.add(productEntity);
        });


        // Get All Products
        // Filter all products for quantity < 2
        // Send Mail with content w.r.t. these filtered products

        System.out.println("I am running now.");
        StringBuilder content = new StringBuilder();
       productEntityListWithLessQuantity.forEach(productEntity -> {
           content.append(productEntity.getProductName());
           content.append(',');
       });

       mailService.sendMail(MAIL_TO, "Product Quantity Low", content.toString());
    }
}
