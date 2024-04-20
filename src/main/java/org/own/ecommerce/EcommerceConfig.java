package org.own.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.own.ecommerce")
public class EcommerceConfig {
	@Bean
	public EntityManager entityManager() {
		return Persistence.createEntityManagerFactory("development").createEntityManager();
	}
}
