package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.practice.config.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="ribbonfeign-service",configuration=RibbonConfiguration.class)
//@EnableFeignClients
public class RibbonFeignclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonFeignclientApplication.class, args);
	}

}
