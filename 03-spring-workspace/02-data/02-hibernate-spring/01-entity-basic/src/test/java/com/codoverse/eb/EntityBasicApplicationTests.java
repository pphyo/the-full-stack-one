package com.codoverse.eb;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.codoverse.eb.entity.User;
import com.codoverse.eb.entity.UserId;
import com.codoverse.eb.repository.UserRepository;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
class EntityBasicApplicationTests {
	
	@Autowired
	UserRepository repo;
	
	User user;
	User saved;

	@BeforeEach
	void setUp() {
		UserId id = new UserId(1L, LocalDateTime.of(2026, 8, 26, 22, 30, 41));
		user = new User(id, "Denise");
		
		saved = repo.save(user);
		
		IO.println(saved);
	}
	
	@Test
	@Order(2)
	void test_for_find() {
		var founded = repo.findById(new UserId(1L, LocalDateTime.of(2026, 8, 26, 22, 30, 41))).orElse(null);
		
		assertThat(founded).isNotNull();
		assertThat(founded.getId()).isNotNull();
		assertThat(founded.getName()).isNotNull();
		assertThat(founded.getName()).isEqualTo("Denise");
	}
	
	@Test
	@Order(1)
	void test_for_save() {
		assertThat(saved).isNotNull();
		assertThat(saved.getId()).isNotNull();
		assertThat(saved.getName()).isNotNull();
		assertThat(saved.getName()).isEqualTo("Denise");
		
	}

}
