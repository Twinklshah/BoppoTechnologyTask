package com.boppotechnology.task2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId1;
	private String username;
	private String password;

	

}
