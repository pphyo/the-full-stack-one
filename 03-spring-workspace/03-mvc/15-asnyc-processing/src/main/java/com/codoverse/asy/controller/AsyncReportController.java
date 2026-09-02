package com.codoverse.asy.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.codoverse.asy.model.Report;
import com.codoverse.asy.service.ReportService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AsyncReportController {
	
	private final ReportService service;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/report/callable")
	public Callable<String> handleGetReportViaCallable(Model model) {
		IO.println("Tomcat Thread (Callable entry): " + Thread.currentThread().getName());
		return () -> {
			IO.println("Async worker thread (Callable run): " + Thread.currentThread().getName());
			
			Report report = service.generateHeavyReport("Callable");
			model.addAttribute("report", report);
			model.addAttribute("asyncType", "Callable");
			return "report-view";
		};
	}
	
	@GetMapping("/report/deferred")
	public DeferredResult<ModelAndView> handleGetReportViaDeferredResult() {
		IO.println("Tomcat Thread (Deferred entry): " + Thread.currentThread().getName());
		
		DeferredResult<ModelAndView> deferredResult = new DeferredResult<>(5000L);
		
		deferredResult.onTimeout(() -> {
			ModelAndView timeoutMav = new ModelAndView("report-view");
			timeoutMav.addObject("error", "Request timeout. Please try again.");
			deferredResult.setResult(timeoutMav);
		});
		
		CompletableFuture.runAsync(() -> {
			IO.println("Custom Worker Thread (Deferred run): " + Thread.currentThread().getName());
			
			try {
				Report report = service.generateHeavyReport("DeferredResult");
				
				ModelAndView mav = new ModelAndView("report-view");
				mav.addObject("report", report);
				mav.addObject("asyncType", "DeferredResult");
				
				deferredResult.setResult(mav);
			} catch (Exception e) {
				deferredResult.setErrorResult(e);
			}
		});
		
		return deferredResult;
	}

}
