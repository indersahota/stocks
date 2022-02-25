package com.ecomerce.stocks.service;

import com.ecomerce.stocks.dao.BrandJPA;
import com.ecomerce.stocks.dao.OfferJPA;
import com.ecomerce.stocks.dao.ProductJPA;
import com.ecomerce.stocks.entity.BrandEntity;
import com.ecomerce.stocks.entity.OffersEntity;
import com.ecomerce.stocks.entity.ProductEntity;
import com.ecomerce.stocks.exception.ProductNotFoundException;
import com.ecomerce.stocks.library.CustomerTypeLibrary;
import com.ecomerce.stocks.model.Product;
import com.ecomerce.stocks.util.ProductUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductJPA productJPA;

    @Autowired
    ProductService productService;

    @Autowired
    OfferJPA  offerJPA;

    @Autowired
    BrandJPA brandJPA;
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try {
            List<ProductEntity> productEntities = productJPA.findAll();
            productList = ProductUtility.getListOfProductsFromProductEntities(productEntities);
        }
        catch (Exception e){

            e.printStackTrace();

        }
        modifyDiscountedPriceMemorySaved(productList);
        return productList;
    }

    @Override
    public List<Product> getAllProductsByBrandId(Integer brandId) {
        return ProductUtility.getListOfProductsFromProductEntities(productJPA.getByBrandId(brandId));
    }

    @Override
    public List<Product> getAllProductsByBrandName(String brandName) {
        BrandEntity brandEntity = brandJPA.getByBrandName(brandName);
        return getAllProductsByBrandId(brandEntity.getBrandId());
       // return ProductUtility.
         //       getListOfProductsFromProductEntities(productJPA.getByBrandId(brandEntity.getBrandId()));
    }

    @Override
    public List<Product> getAllProductsByCategoryId(Integer categoryId) {

        return ProductUtility.getListOfProductsFromProductEntities(productJPA.getByCategoryId(categoryId));

    }

    @Override
    public List<Product> getAllProductsByCustomerType(String customerType)
        throws ProductNotFoundException {
       Integer customerTypeId=CustomerTypeLibrary.getCustomerIdFromCustomerName(customerType);
       if(customerTypeId == null)
           throw new ProductNotFoundException("No Product with Customer Type.");
       return ProductUtility.getListOfProductsFromProductEntities(productJPA.getByCustomerTypeId(customerTypeId));
    }

    public List<OffersEntity> getAllOffers(){
        return offerJPA.findAll();
    }

    public List<Product> modifyDiscountedPrice(List<Product> productList ){
        List<OffersEntity> offersEntityList = getAllOffers();
        if(CollectionUtils.isEmpty(offersEntityList))
        {
            return productList;
        }
        List<Product> discountedProducts = new ArrayList<>();
        offersEntityList.forEach(offersEntity ->{
            if("brand".equalsIgnoreCase(offersEntity.getOfferOnType()))
            {

                String discountedBrand = offersEntity.getOfferTypeValue();
                List<Product> specificBrandProducts = ProductUtility.getProductsByBrand(productList, discountedBrand);
                Integer discount = offersEntity.getDiscountPercentage();
                specificBrandProducts.forEach(specificBrandProduct -> {
                    Integer originalPrice = specificBrandProduct.getPrice();
                    Integer discountedPrice = ((100 - discount) / 100 ) * originalPrice;
                    specificBrandProduct.setPrice(discountedPrice);
                    discountedProducts.add(specificBrandProduct);
                });
                List<Product> productsOfDifferentBrand = ProductUtility.getProductsNotByBrand(productList, offersEntity.getOfferTypeValue());
                discountedProducts.addAll(productsOfDifferentBrand);
            }
            else if("customerType".equalsIgnoreCase(offersEntity.getOfferOnType()))
            {
                String discountedCustomerType = offersEntity.getOfferTypeValue();
            }
        });

        return discountedProducts;

    }

    public void modifyDiscountedPriceMemorySaved(List<Product> productList ){
        List<OffersEntity> offersEntityList = getAllOffers();
        if(CollectionUtils.isEmpty(offersEntityList))
        {
            return;
        }

        offersEntityList.forEach(offersEntity ->{
            Integer discount = offersEntity.getDiscountPercentage();
            if("brand".equalsIgnoreCase(offersEntity.getOfferOnType()))
            {
                productList.forEach(product -> {
                    if(!product.getIsDiscounted()
                            && product.getBrand().getBrandId().toString().equals(offersEntity.getOfferTypeValue()))
                    {
                        Integer originalPrice = product.getPrice();
                        Integer discountedPrice = originalPrice * (100 - discount) / 100;
                        product.setPrice(discountedPrice);
                        product.setIsDiscounted(true);
                    }
                });
            }

            else if("customerType".equalsIgnoreCase(offersEntity.getOfferOnType())) {
                productList.forEach(product -> {
                    if (!product.getIsDiscounted() &&
                            product.getCustomerType().getCustomerTypeId().toString().equals((offersEntity.getOfferTypeValue()))) {
                        Integer originalPrice = product.getPrice();
                        Integer discountedPrice = originalPrice * (100 - discount) / 100;
                        product.setPrice(discountedPrice);
                        product.setIsDiscounted(true);
                    }
                });
            }
        });
    }
    }


