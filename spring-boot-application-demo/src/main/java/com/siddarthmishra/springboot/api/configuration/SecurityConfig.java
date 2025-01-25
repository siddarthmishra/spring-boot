package com.siddarthmishra.springboot.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorize -> authorize
				.requestMatchers(HttpMethod.POST, "/users", "/introducer-activity", "/introducers").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/users", "/introducer-activity", "/introducers").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/users/**", "/introducer-activity/**", "/introducers/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PATCH, "/users", "/introducer-activity", "/introducers").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/users/**", "/introducer-activity/**", "/introducers/**").hasAnyRole("ADMIN", "USER")
				.requestMatchers("/**").permitAll()
				// .anyRequest().authenticated()
		).httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
