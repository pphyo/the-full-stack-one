package com.codoverse.inherit.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.codoverse.inherit.entity.Account;

public interface AccountRepository extends JpaRepositoryImplementation<Account, UUID> {

}
