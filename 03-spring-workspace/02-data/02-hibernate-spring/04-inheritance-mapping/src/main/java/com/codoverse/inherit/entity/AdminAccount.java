package com.codoverse.inherit.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "admin_accounts")
@DiscriminatorValue("1")
public class AdminAccount extends Account {

//	@Column(nullable = false)
	private int age;
	
//	@Column(nullable = false)
	private String fullName;
	
}
