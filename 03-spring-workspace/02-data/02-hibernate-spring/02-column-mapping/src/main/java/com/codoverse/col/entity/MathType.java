package com.codoverse.col.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "math_types")
public class MathType {
	
	@Id
	private Long id;
	
	private BigDecimal bigDecimal;
	private BigInteger bigInteger;

}
