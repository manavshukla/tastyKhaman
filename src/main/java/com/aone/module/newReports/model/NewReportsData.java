package com.aone.module.newReports.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class NewReportsData implements Serializable {

	private static final long serialVersionUID = 7985809150363791307L;
	private String name;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private String reportPath;
	private long contactId;
	private String contactName;
	private long contactCategoryId;
	private double preBalance;
	private String vehicleNo;
	private String contactNo;
	
	public long getContactCategoryId() {
		return contactCategoryId;
	}
	public void setContactCategoryId(long contactCategoryId) {
		this.contactCategoryId = contactCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getReportPath() {
		return reportPath;
	}
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public double getPreBalance() {
		return preBalance;
	}
	public void setPreBalance(double preBalance) {
		this.preBalance = preBalance;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "NewReportsData [name=" + name + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", reportPath=" + reportPath + ", contactId=" + contactId + ", contactName=" + contactName
				+ ", contactCategoryId=" + contactCategoryId + ", preBalance=" + preBalance + ", vehicleNo=" + vehicleNo
				+ ", contactNo=" + contactNo + "]";
	}
}
