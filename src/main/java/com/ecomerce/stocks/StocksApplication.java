package com.ecomerce.stocks;

import com.ecomerce.stocks.library.CustomerTypeLibrary;
import com.ecomerce.stocks.model.CustomerTypeEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksApplication.class, args);
	}

	/*@Bean
	public CustomerTypeLibrary getCustomerTypeLibrary()
	{
		CustomerTypeLibrary customerTypeLibrary = new CustomerTypeLibrary();
		customerTypeLibrary.addPair(1, CustomerTypeEnum.MEN);
		customerTypeLibrary.addPair(2, CustomerTypeEnum.WOMEN);
		customerTypeLibrary.addPair(3, CustomerTypeEnum.KIDS);

		return customerTypeLibrary;
	}*/

}
