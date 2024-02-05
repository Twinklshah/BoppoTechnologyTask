package com.boppotechnology.task2.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boppotechnology.task2.model.Users1;
@Repository
public interface Users1Repository extends JpaRepository<Users1, Long>{
	Optional<Users1> findByUsername (String username);
	Page<Users1>findAll(Pageable pageable);
	Page<Users1> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
}
