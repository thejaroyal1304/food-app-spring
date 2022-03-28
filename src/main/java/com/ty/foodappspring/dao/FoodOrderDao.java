package com.ty.foodappspring.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappspring.dto.FoodOrder;
import com.ty.foodappspring.dto.Item;
import com.ty.foodappspring.dto.Product;
import com.ty.foodappspring.dto.User;
import com.ty.foodappspring.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	@Autowired
	private FoodOrderRepository fr;
	@Autowired
	private UserDao ud;

	public FoodOrder saveFoodOrder(int uid, FoodOrder f) {
		List<Item> items = f.getItems();
		if (items != null) {
			for (Item i : items) {
				i.setF(f);
			}
		}
		User u = ud.getUser(uid);
		if (u != null) {
			f.setU(u);
			return fr.save(f);
		}
		return null;
	}

	public FoodOrder getFoodOrder(int id) {
		Optional<FoodOrder> opt = fr.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public FoodOrder updateFoodOrder(int id, FoodOrder f) {
		FoodOrder fo = getFoodOrder(id);
		if (fo != null) {
			fr.save(f);
			return f;
		}
		return null;
	}

	public List<FoodOrder> getAllFoodOrders() {
		return fr.findAll();
	}

	public boolean deleteFoodOrder(int id) {
		FoodOrder f = fr.getById(id);
		if (f != null) {
			fr.deleteById(id);
			return true;
		}
		return false;
	}
}
