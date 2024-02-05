package com.boppotechnology.task2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.boppotechnology.task2.model.Users1;
import com.boppotechnology.task2.repository.Users1Repository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Users1Service {
	@Autowired
	private Users1Repository repository;
	
	
	public Users1 saveUser1(Users1 user) {
		return repository.save(user);
		
	}
	
	public Page<Users1> getUser(Pageable pageable) {
		return repository.findAll(pageable);
	
	}
	
	public Page<Users1> searchUsers(String search, Pageable pageable) {
        return repository.findByUsernameContainingIgnoreCase(search, pageable);
    }
	
	public boolean isValidUser(String userName1, String userPassword) {
		
		Optional<Users1> user = repository.findByUsername(userName1);
		if(user.isPresent() && user.get().getPassword().equals(userPassword)){
			return true;
		}
       
		
        return false;
    }
}


