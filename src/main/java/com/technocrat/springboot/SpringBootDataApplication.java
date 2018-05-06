package com.technocrat.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// uncomment it if you want to use properties file with JavaConfig to configure DB. 
/*@ComponentScan(basePackages="com.technocrat")*/
public class SpringBootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataApplication.class, args);
	}
}
