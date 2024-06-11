package com.petgo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		.csrf().disable()
		.authorizeHttpRequests((requests)-> requests
				.requestMatchers(
						"/v3/api-docs/**",
						"/swagger-ui/**",
						"/swagger-ui/index.html")
				.permitAll()
				
				.requestMatchers(
						HttpMethod.POST, "/Consulta/", "/Especialidade/", "/Pet/", "/Propietario/", "/Tipo/", "/Veterinario/")
				.authenticated()
				
				.requestMatchers(
						HttpMethod.GET, "/Consulta/", "/Especialidade/", "/Pet/", "/Propietario/", "/Tipo/", "/Veterinario/")
				.permitAll()
				
				.requestMatchers(
						HttpMethod.DELETE, "/Consulta/", "/Especialidade/", "/Pet/", "/Propietario/", "/Tipo/", "/Veterinario/")
				.authenticated()
				.requestMatchers(
						HttpMethod.PUT, "/Consulta/", "/Especialidade/", "/Pet/", "/Propietario/", "/Tipo/", "/Veterinario/")
				.authenticated()
				
				.anyRequest()
				.denyAll()
				
				)
				.httpBasic();
		return http.build();
		
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService(){
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("Jonas")
				.password("157")
				.build();
		return new InMemoryUserDetailsManager(user);
		
	}
	
}