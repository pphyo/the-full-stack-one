package com.codoverse.col;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.codoverse.col.entity.DateTimeType;

import jakarta.persistence.EntityManager;

@DataJpaTest
class ApplicationTests {
	
	@Autowired
	SimpleJpaRepository<DateTimeType, Long> repo;

	@Test
	void run() {}
	
	@Test
	@Disabled
	void test() {
		
		var dt = new DateTimeType();
		dt.setId(1L);
		dt.setLocalTime(LocalTime.of(1, 1, 1, 123));
		
		repo.save(dt);
		
		var founded = repo.findById(1L);
		assertThat(founded).isNotNull();
		IO.println(founded);
		
	}
	
	@TestConfiguration
	static class TestConfig {
		@Bean
		SimpleJpaRepository<DateTimeType, Long> simpleJpaRepository(EntityManager entityManager) {
			return new SimpleJpaRepository<>(DateTimeType.class, entityManager);
		}
	}

}
