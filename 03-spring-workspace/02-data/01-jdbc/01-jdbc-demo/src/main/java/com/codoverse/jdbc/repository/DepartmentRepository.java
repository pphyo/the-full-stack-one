package com.codoverse.jdbc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.codoverse.jdbc.model.Department;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {

	private final JdbcClient jdbcClient;
	
	public long save(Department department) {
		var keyHolder = new GeneratedKeyHolder();
		jdbcClient.sql("insert into departments(name) values (:name)")
			.param("name", department.getName())
			.update(keyHolder);
		
		return keyHolder.getKey().longValue();
	}
	
	public void update(Long id, Department department) {
		jdbcClient.sql("update departments set name = :name where id = :id")
			.param("name", department.getName())
			.param("id", id)
			.update();
	}
	
	public void delete(Long id) {
		jdbcClient.sql("delete from departments where id = :id")
			.param("id", id)
			.update();
	}
	
	public List<Department> findAll() {
		return jdbcClient.sql("select * from departments")
				.query(Department.class)
				.list();
	}

	public Optional<Department> findById(long id) {
		return jdbcClient.sql("select * from departments where id = :id")
				.param("id", id)
				.query(Department.class)
				.optional();
	}

}
