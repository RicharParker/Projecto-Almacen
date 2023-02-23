package com.ulsa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigUno implements WebMvcConfigurer{
	public void addViewControllers (ViewControllerRegistry regestry) {
		regestry.addViewController("/home").setViewName("home");
		regestry.addViewController("/").setViewName("home");
		regestry.addViewController("/panel").setViewName("panel");
		regestry.addViewController("/login").setViewName("login");
	}

}
