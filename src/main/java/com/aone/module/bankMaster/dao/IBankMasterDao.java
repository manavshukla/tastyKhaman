package com.aone.module.bankMaster.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.bankMaster.model.BankMaster;

public interface IBankMasterDao extends IBaseMasterRepository<BankMaster , Long>{

	public List<BankMaster> checkBankName(String fieldName, BankMaster bankMaster);
}
