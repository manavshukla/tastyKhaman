package com.aone.module.sales.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.commons.utils.DateUtils;
import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.contact.model.Contact;
import com.aone.module.sales.dao.ISalesDao;
import com.aone.module.sales.model.Sales;

@Lazy
@Repository("salesDaoImpl")
public class SalesDaoImpl extends AbstractBaseMasterRepository<Sales , Long> implements ISalesDao {

	@Override
	public Class<Sales> getClazz() {
		return Sales.class;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Sales> getActiveData(SearchData<Sales> searchData) {
		/*long createdBy = -1;
		if(!isPublicModule()) {
			createdBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
			if(createdBy == 0) {
				throw new AuthenticationFailedException("Login user not found");
			}
		}*/
		TypedQuery<Sales> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);
		
		if(searchData != null) {
			Sales sales = searchData.getData();
			if(sales!=null) {
				sales.setBookingDate(DateUtils.formateDateOnly(sales.getBookingDate()));
				sales.setOrderDate(DateUtils.formateDateOnly(sales.getOrderDate()));				
			}
			if(sales != null && sales.getOrderType() > 0) {
				query.setParameter("orderType", sales.getOrderType());
			}
			if(sales != null ) {				
				if(sales.getSearchValue() != null && !sales.getSearchValue().isEmpty()) {
					query.setParameter("searchValue", "%"+sales.getSearchValue()+"%");
				}
				
				if(sales.getBookingDate() != null) {
					query.setParameter("bookingDate", sales.getBookingDate());
				}
				
				if(sales.getOrderDate() != null) {
					query.setParameter("orderDate", sales.getOrderDate());
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
	public Long getActiveDataCount(SearchData<Sales> searchData) {
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
		if(searchData != null) {
			Sales sales = searchData.getData();
			if(sales!=null) {
				sales.setBookingDate(DateUtils.formateDateOnly(sales.getBookingDate()));
				sales.setOrderDate(DateUtils.formateDateOnly(sales.getOrderDate()));				
			}
			
			if(sales != null && sales.getOrderType() > 0) {
				query.setParameter("orderType", sales.getOrderType());
			}
			if(sales != null ) {
				if(sales.getSearchValue() != null && !sales.getSearchValue().isEmpty()) {
					query.setParameter("searchValue", "%"+sales.getSearchValue()+"%");
				}
				
				if(sales.getBookingDate() != null) {
					query.setParameter("bookingDate", sales.getBookingDate());
				}
				
				if(sales.getOrderDate() != null) {
					query.setParameter("orderDate", sales.getOrderDate());
				}				
			}
		}
//		if(!isPublicModule()) {
//			query.setParameter("createdBy", createdBy);
//		}
		return query.getSingleResult();
	}
	
	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<Sales> searchData, boolean isGetAll, boolean isCountQuery, Class<R> clazz){
		StringBuilder queryBuilder = new StringBuilder(50);
		
		if(isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e left join  "+Contact.class.getName()+ " c on e.contactId = c.id ");
		if(!isGetAll) {
			queryBuilder.append(" where ");
			if(isPublicModule()) {
				queryBuilder.append(" e.deleted = :deleted ");
			} else {
				/*queryBuilder.append(" e.createdBy = :createdBy AND ");*/
				if(searchData != null) {
					Sales sales = searchData.getData();
					if(sales != null && sales.getOrderType() > 0) {
						queryBuilder.append(" e.orderType = :orderType AND ");
					}
					if(sales != null ) {
						if(sales.getSearchValue() != null && !sales.getSearchValue().isEmpty()) {
							queryBuilder.append(" (c.fname like :searchValue or c.mobile like :searchValue) AND");
						}
						
						if(sales.getBookingDate() != null) {
							queryBuilder.append(" e.bookingDate = :bookingDate AND");
						}
						
						if(sales.getOrderDate() != null) {
							queryBuilder.append(" e.orderDate = :orderDate AND");
						}	
					}
					
					queryBuilder.append(" e.deleted = :deleted ");
				}
			}
		}
		if(searchData.getOrderingData() != null && !isCountQuery) {
			queryBuilder.append(" order by e."+searchData.getOrderingData().getColumn());
			if(searchData.getOrderingData().isDescending()) {
				queryBuilder.append(" desc ");
			}
		}
		TypedQuery<R> query = getEntityManager().createQuery(queryBuilder.toString(), clazz);
		if(searchData.getPaginationData() != null && !isCountQuery) {
			query.setFirstResult(searchData.getPaginationData().getRowsPerPage() * (searchData.getPaginationData().getPageNumber() - 1));
			query.setMaxResults(searchData.getPaginationData().getRowsPerPage());
		}
		return query;
	}

}
