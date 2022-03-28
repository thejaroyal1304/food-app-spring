package com.ty.foodappspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodappspring.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
