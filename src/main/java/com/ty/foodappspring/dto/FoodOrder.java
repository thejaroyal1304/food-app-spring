package com.ty.foodappspring.dto;

import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cname;
	private long cphno;
	private String status;
	private String msg;
	@CreationTimestamp
	private LocalDateTime date;
	private double fcost;
	private double gst;
	@OneToMany(mappedBy = "f",cascade = CascadeType.ALL)
	private List<Item> items;

	@ManyToOne
	@JoinColumn
	private User u;

	public int getId() {
		return id;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}
	
	public double getGst() {
		this.gst=gst/100;
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	@JsonIgnore
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public long getCphno() {
		return cphno;
	}

	public void setCphno(long cphno) {
		this.cphno = cphno;
	}

	public double getFcost() {
		return fcost;
	}

	public void setFcost(double fcost) {
		this.fcost = fcost;
	}

}
