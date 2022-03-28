package com.ty.foodappspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodappspring.dao.FoodOrderDao;
import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dao.UserDao;
import com.ty.foodappspring.dto.FoodOrder;
import com.ty.foodappspring.dto.Item;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.dto.User;
import com.ty.foodappspring.exception.NoIdFoundException;

@Service
public class FoodOrderService {
	@Autowired
	private FoodOrderDao fd;

	public ResponseStructure<FoodOrder> saveFoodOrder(int uid, FoodOrder f) {
		List<Item> items = f.getItems();
		double total = 0;
		for (Item i : items) {
			total = i.getIcost() * i.getQty();
		}
		double totalwithgst = total * f.getGst();
		f.setFcost(totalwithgst);
		FoodOrder foodorder = fd.saveFoodOrder(uid, f);
		ResponseStructure<FoodOrder> rs = new ResponseStructure<FoodOrder>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("Success");
		rs.setData(f);
		return rs;
	}

	public ResponseStructure<FoodOrder> getFoodOrderById(int id) {
		FoodOrder foodorder = fd.getFoodOrder(id);
		ResponseStructure<FoodOrder> rs = new ResponseStructure<FoodOrder>();
		if (foodorder != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(foodorder);
			return rs;
		} else {
			String str = "No Id Found For FoodOrder";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<List<FoodOrder>> getAllFoodOrders() {
		List<FoodOrder> foodorders = fd.getAllFoodOrders();
		ResponseStructure<List<FoodOrder>> rs = new ResponseStructure<List<FoodOrder>>();
		if (foodorders != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(foodorders);
			return rs;
		} else {
			String str = "No FoodOrder Added Yet,empty list";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<FoodOrder> updateFoodOrder(int id, FoodOrder f) {
		FoodOrder foodorder = fd.updateFoodOrder(id, f);
		ResponseStructure<FoodOrder> rs = new ResponseStructure<FoodOrder>();
		if (foodorder != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Updated");
			rs.setData(f);
			return rs;
		} else {
			String str = "No Id Found to update FoodOrder";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<String> deleteFoodOrderById(int id) {
		boolean res = fd.deleteFoodOrder(id);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		if (res == true) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Deleted");
			rs.setData("Return value is TRUE");
			return rs;
		} else {
			String str = "No Id Found to Delete FoodOrder";
			throw new NoIdFoundException(str);
		}
	}
}
