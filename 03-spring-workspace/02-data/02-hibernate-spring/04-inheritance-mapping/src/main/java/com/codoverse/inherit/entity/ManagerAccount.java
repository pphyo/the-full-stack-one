package com.codoverse.inherit.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "manager_accounts")
@DiscriminatorValue("2")
public class ManagerAccount extends Account {
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

}
