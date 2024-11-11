package com.aone.module.purchase.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.commons.utils.DateUtils;
import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.contact.model.Contact;
import com.aone.module.purchase.dao.IPurchaseDao;
import com.aone.module.purchase.model.Purchase;

@Lazy
@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl extends AbstractBaseMasterRepository<Purchase, Long> implements IPurchaseDao {

	@Override
	public Class<Purchase> getClazz() {
		return Purchase.class;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Purchase> getActiveData(SearchData<Purchase> searchData) {
		/*
		 * long createdBy = -1; if(!isPublicModule()) { createdBy =
		 * NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().
		 * getName()).getAuthToken()); if(createdBy == 0) { throw new
		 * AuthenticationFailedException("Login user not found"); } }
		 */
		TypedQuery<Purchase> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);

		if (searchData != null) {
			Purchase purchase = searchData.getData();
			
			if (purchase != null) {
				if (purchase.getContactId()>0) {
					query.setParameter("contactId", purchase.getContactId());
				}
				if (purchase.getSearchValue()!= null && !purchase.getSearchValue().isEmpty()) {
					query.setParameter("searchValue", "%" + purchase.getSearchValue() + "%");
				}
				if (purchase.getPurchaseDate() != null) {
					purchase.setPurchaseDate(DateUtils.formateDateOnly(purchase.getPurchaseDate()));
					query.setParameter("purchaseDate", purchase.getPurchaseDate());
				}
			}

		}
		/*
		 * if(!isPublicModule()) { query.setParameter("createdBy", createdBy); }
		 */
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Long getActiveDataCount(SearchData<Purchase> searchData) {
		// long createdBy = -1;
		if (!isPublicModule()) {
			/*
			 * createdBy =
			 * NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().
			 * getName()).getAuthToken()); if(createdBy == 0) { throw new
			 * AuthenticationFailedException("Login user not found"); }
			 */
		}
		/*
		 * StringBuilder queryBuilder = new StringBuilder(50);
		 * queryBuilder.append(SELECT_COUNT_PREFIX);
		 * queryBuilder.append(getClazz().getName());
		 * queryBuilder.append(" e where e.deleted = :deleted"); TypedQuery<Long> query
		 * = getEntityManager().createQuery(queryBuilder.toString(), Long.class);
		 * query.setParameter("deleted", false); return query.getSingleResult();
		 */
		TypedQuery<Long> query = getQueryObject(searchData, false, true, Long.class);
		query.setParameter("deleted", false);
		if (searchData != null) {
			Purchase purchase = searchData.getData();
			
			if (purchase != null) {
				if (purchase.getContactId()>0) {
					query.setParameter("contactId", purchase.getContactId());
				}
				if (purchase.getSearchValue()!= null && !purchase.getSearchValue().isEmpty()) {
					query.setParameter("searchValue", "%" + purchase.getSearchValue() + "%");
				}
				if (purchase.getPurchaseDate() != null) {
					purchase.setPurchaseDate(DateUtils.formateDateOnly(purchase.getPurchaseDate()));
					query.setParameter("purchaseDate", purchase.getPurchaseDate());
				}
			}

		}		
		// if(!isPublicModule()) {
		// query.setParameter("createdBy", createdBy);
		// }
		return query.getSingleResult();
	}

	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<Purchase> searchData, boolean isGetAll, boolean isCountQuery,
			Class<R> clazz) {
		StringBuilder queryBuilder = new StringBuilder(50);

		if (isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e left join  "+Contact.class.getName()+ " c on e.contactId = c.id ");
		if (!isGetAll) {
			queryBuilder.append(" where 1=1 ");
			if (isPublicModule()) {
				queryBuilder.append(" AND e.deleted = :deleted ");
			} else {
				/* queryBuilder.append(" e.createdBy = :createdBy AND "); */
				if (searchData != null) {
					Purchase purchase = searchData.getData();
					if (purchase != null) {
						if(purchase.getSearchValue() != null && !purchase.getSearchValue().isEmpty()) {
							queryBuilder.append(" AND (c.fname like :searchValue or c.mobile like :searchValue) ");
						}
						
						if (purchase.getContactId() > 0) {
							queryBuilder.append(" AND e.contactId = :contactId ");
						}
						
						if (purchase.getPurchaseDate()!=null) {
							queryBuilder.append(" AND e.purchaseDate = :purchaseDate ");
						}
					}
					queryBuilder.append(" AND e.deleted = :deleted ");
				}
			}
		}
		if (searchData != null) {
			if (searchData.getOrderingData() != null && !isCountQuery) {
				queryBuilder.append(" order by e." + searchData.getOrderingData().getColumn());
				if (searchData.getOrderingData().isDescending()) {
					queryBuilder.append(" desc ");
				}
			}
		}
		TypedQuery<R> query = getEntityManager().createQuery(queryBuilder.toString(), clazz);
		if (searchData != null) {
			if (searchData.getPaginationData() != null && !isCountQuery) {
				query.setFirstResult(searchData.getPaginationData().getRowsPerPage()
						* (searchData.getPaginationData().getPageNumber() - 1));
				query.setMaxResults(searchData.getPaginationData().getRowsPerPage());
			}
		}
		return query;
	}

}
