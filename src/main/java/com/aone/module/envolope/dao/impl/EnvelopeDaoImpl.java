package com.aone.module.envolope.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.envolope.dao.IEnvelopeDao;
import com.aone.module.envolope.model.Envelope;

@Lazy
@Repository("envelopeDaoImpl")
public class EnvelopeDaoImpl extends AbstractBaseMasterRepository<Envelope  , Long> implements IEnvelopeDao   {

	@Override
	public Class<Envelope> getClazz() {
		return Envelope.class;
	}

}
