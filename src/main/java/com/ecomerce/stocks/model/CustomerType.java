package com.ecomerce.stocks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerType {
    private Integer customerTypeId;
    private CustomerTypeEnum customerTypeName;
}
