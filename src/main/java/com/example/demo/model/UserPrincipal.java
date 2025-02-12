package com.example.demo.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;


public class UserPrincipal implements UserDetails{
	
	
	private Model obj;
	

	public UserPrincipal(Model obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		System.out.println("here - 4");

		// TODO Auto-generated method stub
		return obj.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("here - 5");

		// TODO Auto-generated method stub
		return obj.getName();
		
	}

}
