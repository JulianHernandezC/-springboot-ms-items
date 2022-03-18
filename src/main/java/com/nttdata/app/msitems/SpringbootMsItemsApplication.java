package com.nttdata.app.msitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name="servicio-productos")
@EnableFeignClients
@SpringBootApplication
public class SpringbootMsItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMsItemsApplication.class, args);
	}

}
