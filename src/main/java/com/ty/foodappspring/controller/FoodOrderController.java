package com.ty.foodappspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodappspring.dao.FoodOrderDao;
import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dto.FoodOrder;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.service.FoodOrderService;

@RestController
public class FoodOrderController {
	@Autowired
	private FoodOrderService fs;

	@PostMapping("/user/{uid}/foodorder")
	public ResponseStructure<FoodOrder> saveFoodOrder(@PathVariable int uid, @RequestBody FoodOrder f) {
		return fs.saveFoodOrder(uid, f);
	}

	@GetMapping("/foodorder")
	public ResponseStructure<FoodOrder> getFoodOrder(@RequestParam int id) {
		return fs.getFoodOrderById(id);
	}

	@GetMapping("/allfoodorders")
	public ResponseStructure<List<FoodOrder>> getAllFoodOrders() {
		return fs.getAllFoodOrders();
	}

	@PutMapping("/foodorder")
	public ResponseStructure<FoodOrder> updateFoodOrder(@RequestParam int id, @RequestBody FoodOrder f) {
		return fs.updateFoodOrder(id, f);
	}

	@DeleteMapping("/foodorder")
	public ResponseStructure<String> DeleteProduct(@RequestParam int id) {
		return fs.deleteFoodOrderById(id);
	}
}
