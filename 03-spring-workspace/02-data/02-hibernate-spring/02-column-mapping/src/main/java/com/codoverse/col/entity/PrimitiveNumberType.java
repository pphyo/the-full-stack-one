package com.codoverse.col.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "primitive_number_types")
public class PrimitiveNumberType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private UUID id;
	
	private byte byteVal;
	private short shortVal;
	private int intVal;
	private long longVal;
	
	private float floatVal;
	private double doubleVal;

}

// decimal(10,2) // 00000000.00