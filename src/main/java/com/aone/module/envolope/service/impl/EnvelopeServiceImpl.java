package com.aone.module.envolope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.envolope.dao.IEnvelopeDao;
import com.aone.module.envolope.model.Envelope;
import com.aone.module.envolope.service.IEnvelopeService;

@Lazy
@Service("envelopeServiceImpl")
public class EnvelopeServiceImpl extends AbstractBaseMasterService<Envelope  , Long, IEnvelopeDao   >
		implements IEnvelopeService  {

	private IEnvelopeDao  envelopeDao;

	@Override
	public IEnvelopeDao getRepository() {
		return getEnvelopeDao();
	}

	public IEnvelopeDao getEnvelopeDao() {
		return envelopeDao;
	}

	@Autowired
	@Qualifier(value = "envelopeDaoImpl")
	public void setEnvelopeDao(IEnvelopeDao envelopeDao) {
		this.envelopeDao = envelopeDao;
	}

}
