package com.codoverse.jdbc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codoverse.jdbc.model.Department;
import com.codoverse.jdbc.repository.DepartmentRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	DepartmentRepository repo;
	
	@ParameterizedTest
	@Order(2)
	@CsvSource({
		"2, Marketing Department",
		"3, HR Department"
	})
	void test_update_department(Long id, String depName) {
		var foundedDep = repo.findById(id).orElse(null);
		foundedDep.setName(depName);
		repo.update(id, foundedDep);
		
		var updatedDep = repo.findById(id).orElse(null);
		assertThat(updatedDep).isNotNull();
		assertThat(updatedDep.getId()).isEqualTo(id);
		assertThat(updatedDep.getName()).isEqualTo(depName);
	}
	
	@ParameterizedTest
	@Order(1)
	@CsvSource({
		"IT Department",
		"Marketi Department",
		"Hr Department",
		"Finance Department"
	})
	void test_create_department(String depName) {
		
		Department dep = new Department(depName);
				
		var savedId = repo.save(dep);
		
		assertThat(savedId).isNotNull();
		
		var savedDep = repo.findById(savedId).orElse(null);
		
		assertThat(savedDep).isNotNull();
		assertThat(savedDep.getId()).isEqualTo(savedId);
		assertThat(savedDep.getName()).isEqualTo(depName);
	}

}
