package com.aone.module.gstRate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.gstRate.constant.GstRateDbColPojoConstant;

@Entity
@Table(name = "gst_rate")
public class GstRate extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3061859090202317110L;
	
	@Column(name = GstRateDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = GstRateDbColPojoConstant.GST_RATE_PER)
	private double gstRatePer;
	
	@Column(name = GstRateDbColPojoConstant.CGST)
	private double cgst;
	
	@Column(name = GstRateDbColPojoConstant.SGST)
	private double sgst;
	
	@Column(name = GstRateDbColPojoConstant.IGST)
	private double igst;
	
	@Column(name = GstRateDbColPojoConstant.DESCRIPTION)
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGstRatePer() {
		return gstRatePer;
	}
	public void setGstRatePer(double gstRatePer) {
		this.gstRatePer = gstRatePer;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	public double getIgst() {
		return igst;
	}
	public void setIgst(double igst) {
		this.igst = igst;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "GstRate [name=" + name + ", gstRatePer=" + gstRatePer + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", description=" + description + "]";
	}

}
