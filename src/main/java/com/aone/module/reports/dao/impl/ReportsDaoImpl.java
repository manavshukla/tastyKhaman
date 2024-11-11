package com.aone.module.reports.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.address.model.Address;
import com.aone.module.contact.model.Contact;
import com.aone.module.item.model.Item;
import com.aone.module.payments.model.PaymentsMaster;
import com.aone.module.reports.dao.IReportsDao;
import com.aone.module.reports.model.DueOrders;
import com.aone.module.reports.model.EmployeeReports;
import com.aone.module.reports.model.Reports;
import com.aone.module.sales.model.Sales;
import com.aone.module.salesDetails.model.SalesDetails;

@Lazy
@Repository("reportsDaoImpl")
public class ReportsDaoImpl extends AbstractBaseMasterRepository<Reports, Long> implements IReportsDao {

	@Override
	public Class<Reports> getClazz() {
		return Reports.class;
	}
	
	@Override
	public List<DueOrders> getDueOrders(int days, LocalDateTime startDate, LocalDateTime endDate){
		StringBuilder query = new StringBuilder();
		query.append("select new com.aone.module.reports.model.DueOrders( c.fname, c.lname, s.orderDate, s.grossAmount, s.advance ) ")
		.append("from "+ Contact.class.getName() +" c ")
		.append(" join "+ Sales.class.getName() +" s on c.id = s.contactId ")
		.append(" WHERE s.bookingDate >= :startDate and s.bookingDate <= :endDate  and s.deleted= :deleted ")
		.append(" order by s.bookingDate ");
		
		TypedQuery<DueOrders> typeQuery = getEntityManager().createQuery(query.toString(), DueOrders.class);
		typeQuery.setParameter("startDate", startDate);
		typeQuery.setParameter("endDate", endDate);
		typeQuery.setParameter("deleted", false);
		return typeQuery.getResultList();
	}
	@Override
	public List<EmployeeReports> getEmployeeReports(int days, LocalDateTime startDate, LocalDateTime endDate){
		StringBuilder query = new StringBuilder();
		query.append("select new com.aone.module.reports.model.EmployeeReports(pm.transactionDate,s.duration,cm.fname,sd.orderQuantity,im.name,ad.street,cm.lname,cm.vehicleNo,s.netAmount) ")
		.append("from "+ PaymentsMaster.class.getName() +" pm ")
		.append("inner join "+ Contact.class.getName() +" cm ")
		.append(" on pm.contactId = cm.id")
		.append(" left join "+Sales.class.getName() +" s on pm.billId = s.id ")
		.append(" left join "+SalesDetails.class.getName() +" sd on sd.salesId = s.id ")
		.append(" left join "+Item.class.getName() +" im on im.id = sd.itemId ")
		.append(" inner join "+ Address.class.getName() +" ad  on ad.foreinKey = cm.id  ")
		.append(" WHERE pm.transactionDate >= :startDate and pm.transactionDate <= :endDate and s.deleted= :deleted ");
		
		TypedQuery<EmployeeReports> typeQuery = getEntityManager().createQuery(query.toString(), EmployeeReports.class);
		typeQuery.setParameter("startDate", startDate);
		typeQuery.setParameter("endDate", endDate);
		typeQuery.setParameter("deleted", false);
		return typeQuery.getResultList();
	}
}
