package org.avi1606.ubetprojectauthservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.avi1606.ubetprojectauthservices", "org.avi1606.uberprojectentity"})
public class UbetProjectAuthServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbetProjectAuthServicesApplication.class, args);
	}

}
