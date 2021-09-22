package com.example.inventory.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.inventory.filter.AuthFilter;

@Configuration
public class FilterConfig implements WebMvcConfigurer {

	// 認証用フィルタの有効化
	@Bean
	public FilterRegistrationBean<AuthFilter> authFilter() {
		var bean = new FilterRegistrationBean<AuthFilter>(new AuthFilter());
		bean.addUrlPatterns("/admin/*");
		return bean;
	}

}
