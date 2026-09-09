package com.codoverse.inherit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import com.codoverse.inherit.entity.AdminAccount;
import com.codoverse.inherit.entity.Gender;
import com.codoverse.inherit.entity.ManagerAccount;
import com.codoverse.inherit.repositories.AccountRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InheritanceMappingTest {

	@Autowired
	AccountRepository repo;

	@Rollback(false)
	@ParameterizedTest
	@CsvSource({ "codoverse1, admin, Admin@123, 20, Admin User" })
	void test_for_insert_admin(String id, String username, String password, int age, String fullName) {

		AdminAccount acc = new AdminAccount();
		acc.setId(UUID.nameUUIDFromBytes(id.getBytes()));
		acc.setUsername(username);
		acc.setPassword(password);
		acc.setAge(age);
		acc.setFullName(fullName);

		var saved = repo.save(acc);

		assertThat(saved).isNotNull();
		assertThat(saved.getId()).isEqualTo(UUID.nameUUIDFromBytes(id.getBytes()));
		assertThat(saved.getUsername()).isEqualTo(username);
		assertThat(saved.getPassword()).isEqualTo(password);
		assertThat(saved.getAge()).isEqualTo(age);
		assertThat(saved.getFullName()).isEqualTo(fullName);

	}

	@Rollback(false)
	@ParameterizedTest
	@CsvSource("codverse2, manager, Manager@123, Male")
	void test_for_insert_manager(String id, String username, String password, Gender gender) {
		ManagerAccount acc = new ManagerAccount();
		acc.setId(UUID.nameUUIDFromBytes(id.getBytes()));
		acc.setUsername(username);
		acc.setPassword(password);
		acc.setGender(gender);

		var saved = repo.save(acc);

		assertThat(saved).isNotNull();
		assertThat(saved.getId()).isEqualTo(UUID.nameUUIDFromBytes(id.getBytes()));
		assertThat(saved.getUsername()).isEqualTo(username);
		assertThat(saved.getPassword()).isEqualTo(password);
		assertThat(saved.getGender()).isEqualTo(gender);
	}

}
