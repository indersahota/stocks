package com.ecomerce.stocks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StocksAppResponse {
    private boolean isSuccess = false;
    private Object responsePayload;
    private String failureMessage;
}
