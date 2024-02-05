package com.boppotechnology.task2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boppotechnology.task2.model.Users1;
import com.boppotechnology.task2.service.Users1Service;



@RestController
@RequestMapping("/users1")
public class Users1Controller {

	@Autowired
	private Users1Service service;

	//	for testing
	//	@GetMapping("/hello")
	//	public String Hello() {
	//		return "Hello boppo Technology";
	//	}

	@PostMapping("/register")
	public Users1 saveUser(@RequestBody Users1 user) {
		return service.saveUser1(user);
	}

	//	@GetMapping("getAllUser")
	//    public Page<Users1> getUserList(
	//            @RequestParam(name = "page", defaultValue = "0") int page,
	//            @RequestParam(name = "size", defaultValue = "10") int size
	//    ) {
	//        Pageable pageable = PageRequest.of(page, size);
	//        return service.getUser(pageable);
	//    }

	@GetMapping("getAllUser")
	public Page<Users1> getUserList(
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size
			) {
		Pageable pageable = PageRequest.of(page, size);
		if (search != null && !search.isEmpty()) {
			return service.searchUsers(search, pageable);
		} else {
			return service.getUser(pageable);
		}

	}

	@PostMapping("/login")
	public String login(@RequestBody Users1 user) {
		if (service.isValidUser(user.getUsername(), user.getPassword())) {
			return "Login successful!";
		} else {
			return "Invalid credentials";
		}
	}
}



