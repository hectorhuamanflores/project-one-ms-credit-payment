package com.bootcamp.credit.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class CreditPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditPaymentApplication.class, args);
	}

	
	@LoadBalanced
	@Bean
	public WebClient.Builder getWebClient(){
		return  WebClient.builder();
	}
}
