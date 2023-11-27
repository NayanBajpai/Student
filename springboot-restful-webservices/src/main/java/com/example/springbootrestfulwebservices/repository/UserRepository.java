package com.example.springbootrestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootrestfulwebservices.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
