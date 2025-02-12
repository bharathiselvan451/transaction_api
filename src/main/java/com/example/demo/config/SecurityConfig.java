package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailService userDetailService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity HTTPS) throws Exception {
		
		System.out.println("here - 2");

		return HTTPS.csrf(Customizer -> Customizer.disable())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/signin")
						.permitAll()
	            	    .anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
	            .httpBasic(Customizer.withDefaults())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            
	            
	            ).build();
		
		
	}
	
	@Bean
	public AuthenticationProvider provider() {
		
		System.out.println("here - 3");

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailService);
		
		return provider;
		
	}
	
	
}
