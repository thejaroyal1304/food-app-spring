package com.ty.foodappspring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodappspring.dto.FoodOrder;
import com.ty.foodappspring.dto.Item;
import com.ty.foodappspring.repository.ItemRepository;

@Repository
public class ItemDao {
	@Autowired
	private ItemRepository ir;
	@Autowired
	private FoodOrderDao fd;

	public Item saveItem(int fid, Item i) {
		FoodOrder fod = fd.getFoodOrder(fid);
		i.setF(fod);
		if (fod != null) {
			return ir.save(i);
		}
		return null;
	}

	public Item getItemById(int id) {
		Optional<Item> opt = ir.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();

	}

	public Item updateItem(int fid, Item i) {
		Item it = getItemById(fid);
		if (it != null) {
			return ir.save(i);
		}
		return null;
	}

	public List<Item> getAllItems() {
		return ir.findAll();
	}

	public boolean deleteBranch(int id) {
		Item i = getItemById(id);
		if (i != null) {
			ir.deleteById(id);
			return true;
		}
		return false;
	}

}
