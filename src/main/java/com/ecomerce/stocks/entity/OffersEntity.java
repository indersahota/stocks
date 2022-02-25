package com.ecomerce.stocks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "offers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OffersEntity {
    @Id
    @Column(name= "offer_id")
    private Integer offerId;

    @Column(name = "offer_on_type")
    private String offerOnType;

    @Column(name = "offer_type_value")
    private String offerTypeValue;

    @Column(name = "discount_percentage")
    private Integer discountPercentage;
}
