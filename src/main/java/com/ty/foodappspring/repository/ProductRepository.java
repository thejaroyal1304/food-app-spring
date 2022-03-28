package com.ty.foodappspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappspring.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
