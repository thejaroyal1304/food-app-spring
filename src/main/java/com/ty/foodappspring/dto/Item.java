package com.ty.foodappspring.dto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String iname;
	private double icost;
	private int qty;
	@ManyToOne
	@JoinColumn
	private FoodOrder f;

	public FoodOrder getF() {
		return f;
	}

	public void setF(FoodOrder f) {
		this.f = f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public double getIcost() {
		return icost;
	}

	public void setIcost(double icost) {
		this.icost = icost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
