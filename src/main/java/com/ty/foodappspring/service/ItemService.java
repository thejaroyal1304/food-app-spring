package com.ty.foodappspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodappspring.dao.ItemDao;
import com.ty.foodappspring.dao.ResponseStructure;
import com.ty.foodappspring.dto.FoodOrder;
import com.ty.foodappspring.dto.Item;
import com.ty.foodappspring.exception.NoIdFoundException;

@Service
public class ItemService {
	@Autowired
	private ItemDao itd;

	public ResponseStructure<Item> saveItem(int fid, Item i) {
		Item item = itd.saveItem(fid, i);
		ResponseStructure<Item> rs = new ResponseStructure<Item>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("Success");
		rs.setData(i);
		return rs;
	}

	public ResponseStructure<Item> getItemById(int id) {
		Item item = itd.getItemById(id);
		ResponseStructure<Item> rs = new ResponseStructure<Item>();
		if (item != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(item);
			return rs;
		} else {
			String str = "No Id Found For Item";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<List<Item>> getAllItems() {
		List<Item> items = itd.getAllItems();
		ResponseStructure<List<Item>> rs = new ResponseStructure<List<Item>>();
		if (items != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Success");
			rs.setData(items);
			return rs;
		} else {
			String str = "No Item Added Yet,empty list";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<Item> updateItem(int id, Item i) {
		Item item = itd.updateItem(id, i);
		ResponseStructure<Item> rs = new ResponseStructure<Item>();
		if (item != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Updated");
			rs.setData(i);
			return rs;
		} else {
			String str = "No Id Found to update Item";
			throw new NoIdFoundException(str);
		}
	}

	public ResponseStructure<String> deleteItemById(int id) {
		boolean res = itd.deleteBranch(id);
		ResponseStructure<String> rs = new ResponseStructure<String>();
		if (res == true) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMsg("Deleted");
			rs.setData("Return value is TRUE");
			return rs;
		} else {
			String str = "No Id Found to Delete Item";
			throw new NoIdFoundException(str);
		}
	}

}
