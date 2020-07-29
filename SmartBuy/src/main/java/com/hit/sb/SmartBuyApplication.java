package com.hit.sb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.hit.sb.hr.mapper","com.hit.sb.admin.mapper","com.hit.sb.cart.mapper","com.hit.sb.goods.mapper","com.hit.sb.order.mapper"})
public class SmartBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartBuyApplication.class, args);
	}

}
