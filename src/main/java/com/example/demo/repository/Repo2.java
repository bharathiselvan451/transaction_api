package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Model;
import com.example.demo.model.Transactions;

@Repository
public interface Repo2 extends ListCrudRepository<Transactions, Integer> {
	
	List<Transactions> findByuser_name(String name);

}
