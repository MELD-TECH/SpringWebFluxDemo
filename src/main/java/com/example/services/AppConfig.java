package com.example.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;


//@Configuration
public class AppConfig   {
//		String rdbcurl = "r2dbc:h2:mem:///empdb";
	    
	String rdbcurl = "r2dbc:mysql://localhost:3306/test";
		
		  @Bean			  
		  public ConnectionFactory connectionFactory() { 
			  return
		  ConnectionFactories.get(ConnectionFactoryOptions.parse(rdbcurl).mutate()
		  .option(ConnectionFactoryOptions.USER, "root")
		  .option(ConnectionFactoryOptions.PASSWORD, "francis1")
		  .option(ConnectionFactoryOptions.DRIVER, "mysql") 
		  .build() );
		  
		  
		  }
		 
}
