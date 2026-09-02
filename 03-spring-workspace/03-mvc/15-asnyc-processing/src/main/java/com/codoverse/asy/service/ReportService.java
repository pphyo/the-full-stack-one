package com.codoverse.asy.service;

import org.springframework.stereotype.Service;

import com.codoverse.asy.model.Report;
import com.codoverse.asy.repo.ReportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {
	
	private final ReportRepository repo;
	
	public Report generateHeavyReport(String reportType) {
		
		try {
			IO.println("Processing report on thread: " + Thread.currentThread().getName());
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		Report newReport = new Report(reportType + " Report", "This is the heavy content for " + reportType);
		return repo.save(newReport);
		
	}

}
