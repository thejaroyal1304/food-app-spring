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

import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dto.Item;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService is;

	@PostMapping("/foodorder/{fid}/item")
	public ResponseStructure<Item> saveItem(@PathVariable int fid, @RequestBody Item i) {
		return is.saveItem(fid, i);
	}

	@GetMapping("/item")
	public ResponseStructure<Item> getItem(@RequestParam int id) {
		return is.getItemById(id);
	}

	@GetMapping("/allitems")
	public ResponseStructure<List<Item>> getAllItems() {
		return is.getAllItems();
	}

	@PutMapping("/item")
	public ResponseStructure<Item> updateItem(@RequestParam int id, @RequestBody Item i) {
		return is.updateItem(id, i);
	}

	@DeleteMapping("/item")
	public ResponseStructure<String> DeleteItem(@RequestParam int id) {
		return is.deleteItemById(id);
	}
}