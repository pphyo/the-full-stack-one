package com.codoverse.eb.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDateTime createdAt;

}
