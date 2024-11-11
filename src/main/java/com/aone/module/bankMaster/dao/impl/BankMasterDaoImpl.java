package com.aone.module.bankMaster.dao.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.bankMaster.dao.IBankMasterDao;
import com.aone.module.bankMaster.model.BankMaster;

@Lazy
@Repository("bankMasterDaoImpl")
public class BankMasterDaoImpl extends AbstractBaseMasterRepository<BankMaster , Long> implements IBankMasterDao {

	@Override
	public Class<BankMaster > getClazz() {
		return BankMaster.class;
	}

	@Override
	@Transactional(readOnly = true)
	public List<BankMaster> checkBankName(String fieldName, BankMaster bankMaster) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("name", bankMaster.getName());
		params.put("deleted", false);
		return super.getByQueryData(params, Collections.emptyMap());
	}
}
