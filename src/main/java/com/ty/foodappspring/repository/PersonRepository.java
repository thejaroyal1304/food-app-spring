package com.ty.foodappspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappspring.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
