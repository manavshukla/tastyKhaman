package com.aone.module.organizationPaymentTerms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.organizationPaymentTerms.constant.OrganizationPaymentTermsDbColPojoConstant;

@Entity
@Table(name = "organization_payment_terms")
public class OrganizationPaymentTerms extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = OrganizationPaymentTermsDbColPojoConstant.TERMS_DATA)
	private String termsData;
	
	@Column(name = OrganizationPaymentTermsDbColPojoConstant.ORGANIZATION_ID)
	private long organizationId;
	
	@Column(name = OrganizationPaymentTermsDbColPojoConstant.DESCRIPTION)
	private String description;
	
	public String getTermsData() {
		return termsData;
	}
	public void setTermsData(String termsData) {
		this.termsData = termsData;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "OrganizationPaymentTerms [termsData=" + termsData
				+ ", organizationId=" + organizationId + ", description="
				+ description + "]";
	}
}
