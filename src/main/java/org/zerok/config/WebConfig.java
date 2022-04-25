package org.zerok.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zerok.interceptor.AccessControlInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private AccessControlInterceptor accessContorolInterceptor;
	
	private List<String> accessControlParth = Arrays.asList(
			"/**/edit", "/**/update", "/**/write"
		);
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		WebMvcConfigurer.super.addInterceptors(registry);
		
		registry.addInterceptor(accessContorolInterceptor)
			.addPathPatterns(accessControlParth)
			;
	}

}
