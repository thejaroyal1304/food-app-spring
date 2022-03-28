package com.ty.foodappspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodappspring.dao.ProductDao;
import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.dto.User;
import com.ty.foodappspring.exception.NoIdFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductDao pd;

	public ResponseStructure<Product> saveProduct(Product p) {
		Product product = pd.saveProduct(p);
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("Success");
		rs.setData(p);
		return rs;
	}

	public ResponseStructure<Product> getProductById(int id) {
		Product product = pd.getProduct(id);
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		if (product != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(product);
			return rs;
		} else {
			String str = "No Id Found For Product";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<List<Product>> getAllProducts() {
		List<Product> products = pd.getAllProducts();
		ResponseStructure<List<Product>> rs = new ResponseStructure<List<Product>>();
		if (products != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(products);
			return rs;
		} else {
			String str = "No ProductProduct Added Yet,empty list";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<Product> updateProduct(int id, Product p) {
		Product product = pd.updateproduct(id, p);
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		if (product != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Updated");
			rs.setData(p);
			return rs;
		} else {
			String str = "No Id Found to update Product";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<String> deleteProductById(int id) {
		boolean res = pd.deleteProduct(id);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		if (res == true) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Deleted");
			rs.setData("Return value is TRUE");
			return rs;
		} else {
			String str = "No Id Found to Delete Product";
			throw new NoIdFoundException(str);
		}
	}

}
