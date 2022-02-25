package com.ecomerce.stocks.exception;

public class ProductNotFoundException extends Exception{
    String exceptionMessage = null;
    public ProductNotFoundException(String message)
    {
        this.exceptionMessage = message;
    }

    @Override
    public String toString()
    {
        return "Product not found. Reason: " + exceptionMessage;
    }
}
