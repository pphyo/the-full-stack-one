package com.codoverse.eb.entity;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Table(name = "users")
@AllArgsConstructor
@Access(AccessType.PROPERTY)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

	private UserId id;

	private String name;

	@EmbeddedId
	public UserId getId() {
		return id;
	}
	
	public void setId(UserId id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
