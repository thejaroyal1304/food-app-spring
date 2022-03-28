package com.ty.foodappspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappspring.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{

}
