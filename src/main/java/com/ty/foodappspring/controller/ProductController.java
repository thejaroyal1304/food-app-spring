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

import com.ty.foodappspring.dao.ProductDao;
import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.dto.User;
import com.ty.foodappspring.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService ps;

	@PostMapping("/product")
	public ResponseStructure<Product> saveProduct(@RequestBody Product p) {
		return ps.saveProduct(p);
	}

	@GetMapping("/product")
	public ResponseStructure<Product> getProduct(@RequestParam int id) {
		return ps.getProductById(id);
	}

	@GetMapping("/allproducts")
	public ResponseStructure<List<Product>> getAllProducts() {
		return ps.getAllProducts();
	}

	@PutMapping("/product")
	public ResponseStructure<Product> updateProduct(@RequestParam int id, @RequestBody Product p) {
		return ps.updateProduct(id, p);
	}

	@DeleteMapping("/product")
	public ResponseStructure<String> DeleteProduct(@RequestParam int id) {
		return ps.deleteProductById(id);
	}
}
