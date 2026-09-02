package com.codoverse.eb.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.codoverse.eb.entity.User;
import com.codoverse.eb.entity.UserId;

public interface UserRepository extends JpaRepositoryImplementation<User, UserId> {

}
