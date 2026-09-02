package com.codoverse.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.codoverse.auth.entity.AppUser;

public interface UserRepository extends JpaRepositoryImplementation<AppUser, Long> {

	Optional<AppUser> findByUsername(String username);
	
}
