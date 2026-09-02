package com.codoverse.intercept.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.codoverse.intercept.interceptors.ApiKeyInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final ApiKeyInterceptor apiKeyInterceptor;

	public WebConfig(ApiKeyInterceptor apiKeyInterceptor) {
		super();
		this.apiKeyInterceptor = apiKeyInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apiKeyInterceptor)
				.addPathPatterns("/api/**")
				.excludePathPatterns("/api/public/**");
	}

}
