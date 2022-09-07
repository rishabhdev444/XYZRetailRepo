package com.xyzretail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages ="com.xyzretail")
@EntityScan(basePackages = "com.xyzretail")
@EnableEurekaClient
public class XyzRetailWebSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzRetailWebSpringBootApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
