package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Model;
import com.example.demo.model.Transactions;

@Repository
public interface Repo extends CrudRepository<Model, String> {
	
	Model findByname(String name);

    
}
