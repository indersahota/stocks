package com.ecomerce.stocks.library;

import com.ecomerce.stocks.model.CustomerType;
import com.ecomerce.stocks.model.CustomerTypeEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerTypeLibrary {

    public static Map<Integer, CustomerTypeEnum> ID_TO_CUSTOMER_TYPE_ENUM = new LinkedHashMap<>();
    private static Map<Integer, CustomerTypeEnum> idToCustomerTypeMap = new LinkedHashMap<>();

    static
    {
        ID_TO_CUSTOMER_TYPE_ENUM.put(1, CustomerTypeEnum.MEN);
        ID_TO_CUSTOMER_TYPE_ENUM.put(2, CustomerTypeEnum.WOMEN);
        ID_TO_CUSTOMER_TYPE_ENUM.put(3, CustomerTypeEnum.KIDS);
    }

    public  static Integer getCustomerIdFromCustomerName(String customerType) {
        Integer customerId = null;
        for (Map.Entry<Integer, CustomerTypeEnum> entry : ID_TO_CUSTOMER_TYPE_ENUM.entrySet()) {
            // if give value is equal to value from entry
            // print the corresponding key
            if (entry.getValue().equals(customerType))
                customerId= entry.getKey();
            }
        return customerId;
        }
    }

   /* public void addPair(Integer id,CustomerTypeEnum customerTypeEnum){
        this.idToCustomerTypeMap.put(id,customerTypeEnum);
    }

    public CustomerTypeEnum getCustomerTypeById(Integer id){
        if(idToCustomerTypeMap.containsKey(id))
            return idToCustomerTypeMap.get(id);
        else
            throw new RuntimeException("customer type is invalid");

    }

    public CustomerType getCustomerTypeByCustomerTypeId(Integer customerTypeId)
    {
        CustomerTypeEnum customerTypeEnum = getCustomerTypeById(customerTypeId);
        return new CustomerType(customerTypeId, customerTypeEnum);
    }
*/

