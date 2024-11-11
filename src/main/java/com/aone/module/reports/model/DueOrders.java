package com.aone.module.reports.model;

import java.time.LocalDateTime;

public class DueOrders {
	
	private String fname;
	private String lname;
	private LocalDateTime orderDate;
	private double totalAmount;
	private double advance;
	
	public DueOrders(String fname, String lname, LocalDateTime orderDate, double totalAmount, double advance) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.advance = advance;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getAdvance() {
		return advance;
	}
	public void setAdvance(double advance) {
		this.advance = advance;
	}
	
}
