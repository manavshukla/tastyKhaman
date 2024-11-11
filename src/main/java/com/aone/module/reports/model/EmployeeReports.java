package com.aone.module.reports.model;

import java.time.LocalDateTime;

public class EmployeeReports {
	
	
	private LocalDateTime transactionDate;//payment
	private String duration;//SLAES	
	private String fname;//contact
	private Double orderQuantity;//sales details
	private String itemName;//item name
 	private String street;//Contact
  	private String lname;//conatct
  	private String vehicleNo;//contact
  	private Double netAmount;//sales
	public EmployeeReports(LocalDateTime transactionDate, String duration, String fname, Double orderQuantity,
			String itemName, String street, String lname, String vehicleNo, Double netAmount) {
		super();
		this.transactionDate = transactionDate;
		this.duration = duration;
		this.fname = fname;
		this.orderQuantity = orderQuantity;
		this.itemName = itemName;
		this.street = street;
		this.lname = lname;
		this.vehicleNo = vehicleNo;
		this.netAmount = netAmount;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Double getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public Double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	@Override
	public String toString() {
		return "EmployeeReports [transactionDate=" + transactionDate + ", duration=" + duration + ", fname=" + fname + ", orderQuantity=" + orderQuantity + ", itemName=" + itemName + ", street=" + street + ", lname=" + lname
				+ ", vehicleNo=" + vehicleNo + ", netAmount=" + netAmount + "]";
	}
	
}
