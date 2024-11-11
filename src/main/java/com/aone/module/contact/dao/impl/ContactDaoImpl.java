package com.aone.module.contact.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.contact.dao.IContactDao;
import com.aone.module.contact.model.Contact;
import com.aone.module.login.service.ILoginService;

@Lazy
@Repository("contactDaoImpl")
public class ContactDaoImpl extends AbstractBaseMasterRepository<Contact, Long> implements IContactDao  {

	private ILoginService loginService;
	
	public ILoginService getLoginService() {
		return loginService;
	}
	
	@Autowired
	@Qualifier(value="loginServiceImpl")
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public Class<Contact> getClazz() {
		return Contact.class;
	}
	@Override
	public List<Contact> getListByCategory(long categoryId) {
		Map<String, Object> params  = new HashMap<>();
		params.put("deleted", false);
		params.put("contactCategoryId", categoryId);
		return super.getByQueryData(params, new HashMap<>());
	}
	

	@Override
	@Transactional(readOnly = true)
	public List<Contact> getActiveData(SearchData<Contact> searchData) {
		/*long createdBy = -1;
		if(!isPublicModule()) {
			createdBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
			if(createdBy == 0) {
				throw new AuthenticationFailedException("Login user not found");
			}
		}*/
		TypedQuery<Contact> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);
		
		if(loginService.getCurrentLoginUserName()!=null) {
			if(!loginService.getCurrentLoginUserName().equals("admin")) {
			query.setParameter("userName","admin");
			}
		}
		if(searchData != null) {
			Contact contact = searchData.getData();
			if(contact != null ) {
				if(contact.getFname() != null && !contact.getFname().isEmpty()) {
					query.setParameter("fname", "%" + contact.getFname() + "%");
				}
				if(contact.getMobile() != null && !contact.getMobile().isEmpty()) {
					query.setParameter("mobile", "%" + contact.getMobile() + "%");
				}
				if( contact.getContactCategoryId()>0) {
					query.setParameter("contactCategoryId",contact.getContactCategoryId());
				}
			}
			
		}
		/*if(!isPublicModule()) {
			query.setParameter("createdBy", createdBy);
		}*/
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long getActiveDataCount(SearchData<Contact> searchData) {
		//long createdBy = -1;
		if(!isPublicModule()) {
			/*createdBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
			if(createdBy == 0) {
				throw new AuthenticationFailedException("Login user not found");
			}*/
		}
		/*StringBuilder queryBuilder = new StringBuilder(50);
		queryBuilder.append(SELECT_COUNT_PREFIX);
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" e where e.deleted = :deleted");
		TypedQuery<Long> query = getEntityManager().createQuery(queryBuilder.toString(), Long.class);
		query.setParameter("deleted", false);
		return query.getSingleResult();*/
		TypedQuery<Long> query = getQueryObject(searchData, false, true, Long.class);
		query.setParameter("deleted", false);
		if(loginService.getCurrentLoginUserName()!=null) {
			if(!loginService.getCurrentLoginUserName().equals("admin")) {
				query.setParameter("userName","admin");
			}
		}
		if(searchData != null) {
			Contact contact = searchData.getData();
			
			if(contact != null ) {
				if(contact.getFname() != null && !contact.getFname().isEmpty()) {
					query.setParameter("fname", "%" + contact.getFname() + "%");
				}
				if(contact.getMobile() != null && !contact.getMobile().isEmpty()) {
					query.setParameter("mobile", "%" + contact.getMobile() + "%");
				}
				if( contact.getContactCategoryId()>0) {
					query.setParameter("contactCategoryId",contact.getContactCategoryId());
				}
			}
			
		}
//		if(!isPublicModule()) {
//			query.setParameter("createdBy", createdBy);
//		}
		return query.getSingleResult();
	}
	
	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<Contact> searchData, boolean isGetAll, boolean isCountQuery, Class<R> clazz){
		StringBuilder queryBuilder = new StringBuilder(50);
		
		if(isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e ");
		
		if(!isGetAll) {
			queryBuilder.append(" where 1=1 ");
			if(isPublicModule()) {
				queryBuilder.append(" AND e.deleted = :deleted ");
			} else {
				if(loginService.getCurrentLoginUserName()!=null) {
					if(!loginService.getCurrentLoginUserName().equals("admin")) {
						queryBuilder.append(" AND e.userName not like :userName OR e.userName IS NULL ");
					}	
				}
				/*queryBuilder.append(" e.createdBy = :createdBy AND ");*/
				if(searchData != null) {
					Contact contact = searchData.getData();
					if(contact != null ) {
						StringBuilder condition = new StringBuilder();
						if(contact.getFname()!= null && !contact.getFname().isEmpty()) {
							condition.append(" e.fname like :fname ");
						}
						if(contact.getMobile() != null && !contact.getMobile().isEmpty()){
							if(condition.length() > 0) {
								condition.append(" OR ");
							}
							condition.append(" e.mobile like :mobile ");
						}
						if(condition.length() > 0) {
							queryBuilder.append( " AND ( " + condition.toString() + " ) ");
						}
					
						if( contact.getContactCategoryId()>0) {
							queryBuilder.append(" AND e.contactCategoryId = :contactCategoryId ");
						}
					}
					queryBuilder.append(" AND e.deleted = :deleted ");
				}
			}
			
		}
		if(searchData != null) {
			if(searchData.getOrderingData() != null && !isCountQuery) {
				queryBuilder.append(" order by e."+searchData.getOrderingData().getColumn());
				if(searchData.getOrderingData().isDescending()) {
					queryBuilder.append(" desc ");
				}
			}
		}
		TypedQuery<R> query = getEntityManager().createQuery(queryBuilder.toString(), clazz);
		if(searchData != null) {
			if(searchData.getPaginationData() != null && !isCountQuery) {
				query.setFirstResult(searchData.getPaginationData().getRowsPerPage() * (searchData.getPaginationData().getPageNumber() - 1));
				query.setMaxResults(searchData.getPaginationData().getRowsPerPage());
			}
		}
		return query;
	}

}
