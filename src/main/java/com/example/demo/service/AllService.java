package com.example.demo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Model;
import com.example.demo.model.Transactions;
import com.example.demo.repository.Repo;
import com.example.demo.repository.Repo2;




@Service
public class AllService {
	
	@Autowired
	Repo repo_1;

	@Autowired
	Repo2 repo_2;
	
	
public List<Transactions> fetch(String username){
	
	return repo_2.findByuser_name(username);

	
	
}

public void put(String username, String category, int amount, String date) {
	
	
	if(repo_1.existsById(username)) {
		
		System.out.println("old user");
        System.out.println("one");
		
		//List<Transactions> trans = repo_2.findByuser_name(username);
		//Model user = repo_1.findByname(username);
        System.out.println("two");
		//List<Transactions> trans = new LinkedList<>();

		Transactions new_trans = new Transactions();
		
		new_trans.setAmount(amount);
		new_trans.setCategory(category);
		new_trans.setDate(date);
		
		new_trans.setUser(repo_1.findByname(username));

		//trans.add(new_trans);
		//user.setTransaction(trans);
		
		//System.out.println(trans.get(0).getCategory());
		//System.out.println(trans.get(1).getCategory());

		
		repo_2.save(new_trans);
        System.out.println("three");

		
	}
	
	else {
		
Model user = repo_1.findByname(username);


System.out.println("new user");

		
		Transactions new_trans = new Transactions();
		new_trans.setAmount(amount);
		new_trans.setCategory(category);
		new_trans.setDate(date);
		new_trans.setTrans_id(amount);
		
		List<Transactions> trans = new LinkedList<>();
		trans.add(new_trans);
		
		user.setTransaction(trans);
		
		repo_1.save(user);
		
		
	}
	
	
	try {
		
		
	}
	
	catch(Exception e) {
		
		

		
		
	}
	
	
	}
public boolean register(Model model) {
	
	
	if(repo_1.existsById(model.getName())){
		return false;
	}
	else {
		repo_1.save(model);
		return true;

	}
	
	
	
}
	
	 

}
