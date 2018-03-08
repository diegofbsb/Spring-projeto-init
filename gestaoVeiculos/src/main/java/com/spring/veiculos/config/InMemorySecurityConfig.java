package com.spring.veiculos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("Andre").password("123").roles("USER")
								  .and().withUser("Otavio").password("123").roles("USER")
								  .and().withUser("Marcos").password("123").roles("USER");
	}
}
