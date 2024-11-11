package com.aone.module.contactPayTerms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contactPayTerms.constant.ContactPayTermsDbColPojoConstant;

@Entity
@Table(name = "contact_pay_terms")
public class ContactPayTerms extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = ContactPayTermsDbColPojoConstant.TERM)
	private String term;
	
	@Column(name = ContactPayTermsDbColPojoConstant.DESCRIPTION)
	private String description;

	@Column(name = ContactPayTermsDbColPojoConstant.CONTACT_ID)
	private long contactId;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "ContactPayTerms [term=" + term + ", description=" + description + ", contactId=" + contactId + "]";
	}

}
