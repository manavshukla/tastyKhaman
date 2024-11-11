package com.aone.module.user.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.user.dao.IUserDao;
import com.aone.module.user.model.User;

@Lazy
@Repository("userDaoImpl")
public class UserDaoImpl extends AbstractBaseMasterRepository<User, Long> implements IUserDao {

	@Override
	public Class<User> getClazz() {
		return User.class;
	}

}
