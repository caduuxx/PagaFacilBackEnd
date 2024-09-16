package com.pagafacil.PagaFacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pagafacil.PagaFacil")
public class PagaFacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagaFacilApplication.class, args);
	}

}
