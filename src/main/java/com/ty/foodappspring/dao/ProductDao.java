package com.ty.foodappspring.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository pr;

	public Product saveProduct(Product p) {
		return pr.save(p);
	}

	public Product getProduct(int id) {
		Optional<Product> opt = pr.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public Product updateproduct(int id, Product p) {
		Product product = getProduct(id);
		if (product != null) {
			pr.save(p);
			return p;
		}
		return null;
	}

	public List<Product> getAllProducts() {
		return pr.findAll();
	}

	public boolean deleteProduct(int id) {
		Product p = pr.getById(id);
		if (p != null) {
			pr.deleteById(id);
			return true;

		}
		return false;
	}
}
