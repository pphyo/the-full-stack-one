package com.codoverse.col.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "wrapper_number_types")
public class WrapperNumberType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private UUID id;
	
	private Byte byteVal;
	private Short shortVal;
	private Integer intVal;
	private Long longVar;
	
	private Float floatVal;
	private Double doubleVal;

}
