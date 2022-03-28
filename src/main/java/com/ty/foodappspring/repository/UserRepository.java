package com.ty.foodappspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappspring.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
