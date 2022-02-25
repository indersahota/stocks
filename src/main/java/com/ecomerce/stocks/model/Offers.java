package com.ecomerce.stocks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Offers {
    private Integer offerId;
    private String offerOnType;
    private String offerTypeValue;
    private Integer discountPercentage;

}
