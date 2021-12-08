package com.dipinprojectmatra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class OfficeworkApplication  {



	public static void main(String[] args) {
		SpringApplication.run(OfficeworkApplication.class, args);
	}


}

