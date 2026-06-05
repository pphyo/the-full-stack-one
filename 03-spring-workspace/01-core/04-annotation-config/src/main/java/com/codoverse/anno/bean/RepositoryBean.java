package com.codoverse.anno.bean;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryBean {
	
	public String getRepository() {
		return "Hello from repository bean";
	}

}
