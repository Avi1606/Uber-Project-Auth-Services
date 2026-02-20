package org.avi1606.ubetprojectauthservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UbetProjectAuthServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbetProjectAuthServicesApplication.class, args);
	}

}
