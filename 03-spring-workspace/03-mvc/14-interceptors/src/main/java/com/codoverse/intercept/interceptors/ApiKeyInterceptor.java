package com.codoverse.intercept.interceptors;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {
	
	private static final String VALID_API_KEY = "codoverse-secret-key-123";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String apiKey = request.getHeader("X-API-KEY");
		
		if(VALID_API_KEY.equals(apiKey)) {
			return true;
		}
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write("Error: Invalid or Missing API Key!");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		IO.println("[Interceptor] - postHandle: Controller has executed.");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		IO.println("[Interceptor] - afterCompletion: Request processing complete.");
	}

}
