package com.example.lopputyo.domain;

import org.springframework.data.repository.CrudRepository;

import com.example.lopputyo.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}