package com.codoverse.val.entity;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "user_accounts")
public class UserAccount {

	@Id
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private LocalDate registeredAt;
	
	@AttributeOverrides(
		{
			@AttributeOverride(name = "street", column = @Column(name = "primary_street", nullable = false, length = 50)),
			@AttributeOverride(name = "state", column = @Column(name = "primary_state")),
			@AttributeOverride(name = "country", column = @Column(name = "primary_country")),
			@AttributeOverride(name = "postalCode", column = @Column(name = "primary_postal_code"))
		}
	)
	private Address primaryAddress;
	
	private Address secondaryAddress;
	
	public enum Gender {
		Male, Female, Other
	}
	
}
