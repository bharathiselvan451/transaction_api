package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Model;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repository.Repo;


@Service
public class UserDetailService implements UserDetailsService{

	
	@Autowired
	Repo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Model obj = repo.findByname(username);
		
		if(obj == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		System.out.println(obj.toString());
		
		System.out.println("here - 1");
		
		return new UserPrincipal(obj);
		
		
		
	}

}
