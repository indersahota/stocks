package com.ecomerce.stocks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="Brands")
public class BrandEntity {
    @Id
    @Column(name="brand_id")
    private Integer brandId;

    @Column(name="brand_name")
    private String brandName;

}
