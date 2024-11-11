package com.aone.module.envolope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.envolope.constant.EnvelopeDbColPojoConstant;

@Entity
@Table(name = "envelope")
public class Envelope extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = EnvelopeDbColPojoConstant.TEMPLATE_NAME)
	private String templateName;
	
	@Column(name = EnvelopeDbColPojoConstant.TO_NAME)
	private String toName;
	
	@Column(name = EnvelopeDbColPojoConstant.FROM_NAME)
	private String fromName;

	@Column(name = EnvelopeDbColPojoConstant.ADDRESS_ID)
	private long addressId;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Envelope [templateName=" + templateName + ", toName=" + toName + ", fromName=" + fromName
				+ ", addressId=" + addressId + "]";
	}

}
