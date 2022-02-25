package com.ecomerce.stocks.controller;


import com.ecomerce.stocks.model.Brand;
import com.ecomerce.stocks.service.BrandService;
import com.ecomerce.stocks.service.BrandServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/brands")
public class BrandController {
private static Logger logger = LoggerFactory.getLogger(BrandController.class);
    @Autowired
    BrandService brandService;

    @PostMapping(value ="/add",consumes = "application/json")
    public String add(@RequestBody Brand brand){
        logger.info("Adding new Brand into DB :" + brand);
        String response = brandService.addBrand(brand);
        logger.info("Response for new Brand :" + response );
        return response;
    }

    @PutMapping(value = "/update" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody Brand brand){
        return brandService.updateBrand(brand);

    }

}
