package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Model;
import com.example.demo.model.Transactions;
import com.example.demo.service.AllService;

import org.json.simple.JSONObject;


@RestController
public class Controller {
	
	
	
	
	@Autowired
	AllService service;
	
	

	
	@PostMapping(value ="/transactions", consumes = "application/json", produces = "application/json")
	public void put_transactions(@RequestBody Map jsonString ) {
		JSONObject jsonObj = new JSONObject(jsonString);
		System.out.println(jsonObj);
		System.out.println(jsonObj.get("name"));
		//this.table_1.setBudget(jsonObj.getSt)
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
        System.out.println(username);
		
		
		int amount = Integer.valueOf(jsonObj.get("amount").toString());
		String date = (jsonObj.get("date").toString());
		String category = (jsonObj.get("category").toString());
		
		//Integer id = Integer.valueOf(jsonObj.get("id").toString());


		service.put(username, category, amount, date);
		
		

		//return "here";
	}
	
	
	
	
	@GetMapping(value ="/reports", consumes = "application/json", produces = "application/json")
	public List<Transactions> get_reports() {
		
		
		//System.out.println(obj2.findByuser_name(username).toString());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		return service.fetch(username);
	
	}
	
	@PostMapping("/signin")
	public ResponseEntity<String> register(@RequestBody Model model) {
		
		//obj.save(model);
		if(service.register(model)){
		String responseBody = "Request was successful!";
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
		}
		else {
			String responseBody = "user already exists";
	        return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	
	
	
	
	
}
