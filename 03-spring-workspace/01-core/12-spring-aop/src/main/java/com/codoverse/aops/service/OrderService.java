package com.codoverse.aops.service;

import org.springframework.stereotype.Service;

import com.codoverse.aops.TrackTime;

@Service
public class OrderService {
	
	@TrackTime
	public void processComplexOrder() {
		IO.println("Processing complex Order...");
	}
	
	public void loadSimpleTask() {
		IO.println("Loading simple task..");
	}

}
