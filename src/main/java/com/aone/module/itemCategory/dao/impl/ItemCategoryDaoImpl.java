package com.aone.module.itemCategory.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.itemCategory.dao.IItemCategoryDao;
import com.aone.module.itemCategory.model.ItemCategory;

@Lazy
@Repository("itemCategoryDaoImpl")
public class ItemCategoryDaoImpl extends AbstractBaseMasterRepository<ItemCategory, Long> implements IItemCategoryDao {

	@Override
	public Class<ItemCategory> getClazz() {
		return ItemCategory.class;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ItemCategory> getActiveData(SearchData<ItemCategory> searchData) {
		/*long createdBy = -1;
		if(!isPublicModule()) {
			createdBy = NumberUtils.toLong(CacheRequestUtils.getRequestData(Thread.currentThread().getName()).getAuthToken());
			if(createdBy == 0) {
				throw new AuthenticationFailedException("Login user not found");
			}
		}*/
		TypedQuery<ItemCategory> query = getQueryObject(searchData, false, false, getClazz());
		query.setParameter("deleted", false);
		
		if(searchData != null) {
			ItemCategory itemCategory = searchData.getData();
			if(itemCategory != null ) {
				if(itemCategory.getName() != null && !itemCategory.getName().isEmpty()) {
					query.setParameter("name", "%" + itemCategory.getName() + "%");
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
	public Long getActiveDataCount(SearchData<ItemCategory> searchData) {
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
			ItemCategory itemCategory = searchData.getData();
			
			if(itemCategory != null ) {
				if(itemCategory.getName() != null && !itemCategory.getName().isEmpty()) {
					query.setParameter("name", "%" + itemCategory.getName() + "%");
				}
			}
			
		}
//		if(!isPublicModule()) {
//			query.setParameter("createdBy", createdBy);
//		}
		return query.getSingleResult();
	}
	
	@Override
	protected <R> TypedQuery<R> getQueryObject(SearchData<ItemCategory> searchData, boolean isGetAll, boolean isCountQuery, Class<R> clazz){
		StringBuilder queryBuilder = new StringBuilder(50);
		
		if(isCountQuery) {
			queryBuilder.append(SELECT_COUNT_PREFIX);
		} else {
			queryBuilder.append(SELECT_PREFIX);
		}
		queryBuilder.append(getClazz().getName() + " e ");
		if(!isGetAll) {
			queryBuilder.append(" where ");
			if(isPublicModule()) {
				queryBuilder.append(" e.deleted = :deleted ");
			} else {
				/*queryBuilder.append(" e.createdBy = :createdBy AND ");*/
				if(searchData != null) {
					ItemCategory itemCategory = searchData.getData();
					if(itemCategory != null ) {
						if(itemCategory.getName() != null && !itemCategory.getName().isEmpty()) {
							queryBuilder.append(" e.name like :name AND ");
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
