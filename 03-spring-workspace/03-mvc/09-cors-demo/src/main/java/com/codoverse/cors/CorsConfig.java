package com.codoverse.cors;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(3600);
	}

	@Bean
	DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.build();			
	}
	
	@Bean
	TransactionManager transactionManager(DataSource dataSource) {
		return new JdbcTransactionManager(dataSource);
	}
	
}
