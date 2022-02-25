package com.ecomerce.stocks.entity;

import com.ecomerce.stocks.model.Brand;
import com.ecomerce.stocks.model.Category;
import com.ecomerce.stocks.model.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "product")
public class ProductEntity {
    @Id
    @Column(name ="product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;


    @OneToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;

    @Column(name = "customer_type_id")
    private Integer customerTypeId;

}
