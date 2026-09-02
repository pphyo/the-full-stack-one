package com.codoverse.col.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "text_types")
public class TextType {
	
	@Id
	private Long id;
	
	private String textVal;
	private char charVal;
	private char[] charArray;
	
	private boolean boolVal;
	
	private CharSequence sbVal;

}
