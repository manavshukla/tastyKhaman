package com.aone.module.newReports.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.commons.utils.DateUtils;
import com.aone.module.contact.service.IContactService;
import com.aone.module.item.constant.OrderTypeItemConstant;
import com.aone.module.item.service.IItemService;
import com.aone.module.newReports.dao.INewReportsDao;
import com.aone.module.newReports.model.NewReportsData;
import com.aone.module.newReports.service.INewReportsService;

@Lazy
@Service("newReportsServiceImpl")
public class NewReportsServiceImpl implements INewReportsService {

	private INewReportsDao reportsDao;
	private IItemService itemService;
	private IContactService contactService;

	/**
	 * @return the contactService
	 */
	public IContactService getContactService() {
		return contactService;
	}

	/**
	 * @param contactService
	 *            the contactService to set
	 */
	@Autowired
	@Qualifier(value = "contactServiceImpl")
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}

	public IItemService getItemService() {
		return itemService;
	}

	@Autowired
	@Qualifier(value = "itemServiceImpl")
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	public INewReportsDao getReportsDao() {
		return reportsDao;
	}

	@Autowired
	@Qualifier(value = "newReportsDaoImpl")
	public void setReportsDao(INewReportsDao reportsDao) {
		this.reportsDao = reportsDao;
	}

	@Override
	public ResultSet getItemWiseSalesReportDetails(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean endDateFilter = false;
		boolean saleType = false;
		int count = 0;
		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			endDateFilter = reportsData.getEndDateTime() != null ? true : false;
			saleType = reportsData.getContactId() > 0;
			query.append(
					"SELECT im.name AS spare_part_name, sum(sd.order_quantity) AS quantity FROM item_master im INNER JOIN sales_details sd ON sd.item_id = im.id INNER JOIN sales s ON s.id = sd.sales_id ");

			where.append(" AND im.deleted = 0 AND sd.deleted = 0 AND s.deleted = 0 ");
			
			if (saleType) {
				where.append(" AND s.orderType = ? ");
			}
			if(saleType) {
				
			if(reportsData.getContactId()==2) {
				if (startDateFilter) {
					where.append(" AND s.orderDate >= ? ");
				}
				if (endDateFilter) {
					where.append(" AND s.orderDate <= ? ");
				}
			}else{
				if (startDateFilter) {
					where.append(" AND s.booking_date >= ? ");
				}	
				if (endDateFilter) {
					where.append(" AND s.booking_date <= ? ");
				}				
			}
			}
			
			query.append(where);

			groupBy.append("  GROUP BY im.id,im.name ");
			query.append(groupBy);

			connection = itemService.getConnection();
			statement = connection.prepareStatement(query.toString());
			if (startDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
			}

			if (endDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
			}
			if (saleType) {
				statement.setLong(++count, reportsData.getContactId());
			}
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public ResultSet getEmployeeReport(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean endDateFilter = false;
		boolean contactFilter = false;
		boolean contactCategoryFilter = false;
		int count = 0;
		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			endDateFilter = reportsData.getEndDateTime() != null ? true : false;
			contactFilter = reportsData.getContactId() > 0;
			contactCategoryFilter = reportsData.getContactCategoryId() > 0;
			query.append(
					"select pm.id, DATE_FORMAT(pm.transactionDate,'%d/%m/%Y') as transactionDate,pm.amount,if(pm.cr_dr_flag=1,pm.amount, 0) as creditAmount ,if(pm.cr_dr_flag=2,pm.amount, 0) as debitAmount ,concat(IFNULL(cm.fname,''), '', IFNULL(cm.lname,'')) as name ,concat(IFNULL(ad.street,''), ' ', IF(ad.zipCode > 0, ad.zipCode ,'')) as addressData,sa.duration, sd.items ");
			query.append(
					" from contact_master as cm join payment_master as pm on cm.id = pm.contactId left join sales as sa on pm.billId = sa.id "
							+ " LEFT JOIN (select * from address where id in (select max(id) from address group by  foreignKey)) as ad ON sa.id=ad.foreignKey AND ad.moduleName='SALES_SHIPPING_ADDRESS' "
							+ " LEFT JOIN (select sd.sales_id, GROUP_CONCAT(im.name SEPARATOR ',') as items from sales_details sd LEFT JOIN item_master im on im.id = sd.item_id and im.deleted = 0  WHERE sd.deleted = 0 GROUP BY sd.sales_id) as sd on sd.sales_id = sa.id ");
			query.append(" WHERE pm.deleted=0 AND cm.deleted=0 ");

			if (startDateFilter) {
				query.append(" AND pm.transactionDate >= ? ");
			}

			if (endDateFilter) {
				query.append(" AND pm.transactionDate <= ? ");
			}
			if (contactFilter) {
				query.append(" AND cm.id = ? ");
			}
			if (contactCategoryFilter) {
				query.append(" AND cm.contact_category_id = ? ");
			}
			// groupBy.append(" GROUP BY pm.id,pm.amount ");
			query.append(groupBy);

			connection = itemService.getConnection();
			statement = connection.prepareStatement(query.toString());
			if (startDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
			}

			if (endDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
			}
			if (contactFilter) {
				statement.setLong(++count, reportsData.getContactId());
			}
			if (contactCategoryFilter) {
				statement.setLong(++count, reportsData.getContactCategoryId());
			}
			resultSet = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public ResultSet getWorkerHelperReportDetails(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean endDateFilter = false;
		boolean contactFilter = false;
		int count = 0;
		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			endDateFilter = reportsData.getEndDateTime() != null ? true : false;
			contactFilter = reportsData.getContactId() > 0;
			query.append(
					" SELECT s.id, DATE_FORMAT(pm.transactionDate,'%d/%m/%Y') as transactionDate, if(pm.cr_dr_flag=1, pm.amount, 0) AS creditAmount, if(pm.cr_dr_flag=2, pm.amount, 0) AS debitAmount,concat(IFNULL(c.fname,''), ' ', IFNULL(c.lname,'')) AS name, concat(IFNULL(ad.street,''), ' ', IF(ad.zipCode > 0, ad.zipCode ,'')) AS addressData, s.duration, sd.items"
							+ " FROM sales s INNER JOIN sale_worker_helper swh on swh.sales_id = s.id and swh.deleted = 0 "
							+ " INNER JOIN contact_master c on c.id = s.contact_id and c.deleted = 0 "
							+ " INNER JOIN contact_master cm on cm.id = swh.contactId and cm.deleted = 0 INNER JOIN payment_master pm on pm.contactId = swh.contactId and pm.billId = s.id and pm.deleted = 0 "
							+ " LEFT JOIN (select * from address where id in (select max(id) from address group by  foreignKey)) AS ad ON s.id=ad.foreignKey AND ad.moduleName='SALES_SHIPPING_ADDRESS' LEFT JOIN (select sd.sales_id, GROUP_CONCAT(im.name SEPARATOR ',') as items from sales_details sd LEFT JOIN item_master im on im.id = sd.item_id and im.deleted = 0  WHERE sd.deleted = 0 GROUP BY sd.sales_id) as sd on sd.sales_id = s.id ");
			query.append(" WHERE s.deleted = 0 ");

			if (startDateFilter) {
				query.append(" AND pm.transactionDate >= ? ");
			}

			if (endDateFilter) {
				query.append(" AND pm.transactionDate <= ? ");
			}
			if (contactFilter) {
				query.append(" AND cm.id = ? ");
			}
			// groupBy.append(" GROUP BY pm.id ");
			// query.append(groupBy);
			query.append(" ORDER BY pm.transactionDate ");
			connection = itemService.getConnection();
			statement = connection.prepareStatement(query.toString());
			if (startDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
			}

			if (endDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
			}
			if (contactFilter) {
				statement.setLong(++count, reportsData.getContactId());
			}
			resultSet = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public ResultSet getDriverReportDetails(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean endDateFilter = false;
		boolean contactFilter = false;
		int count = 0;
		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			endDateFilter = reportsData.getEndDateTime() != null ? true : false;
			contactFilter = reportsData.getContactId() > 0;
			query.append(
					" SELECT s.id, DATE_FORMAT(pm.transactionDate,'%d/%m/%Y') as transactionDate, if(pm.cr_dr_flag=1, pm.amount, 0) AS creditAmount, if(pm.cr_dr_flag=2, pm.amount, 0) AS debitAmount,concat(IFNULL(c.fname,''), '', IFNULL(c.lname,'')) AS name, "
							+ " CASE WHEN s.orderType = 1 THEN concat(IFNULL(ad.street, ''), ' ', IF(ad.zipCode > 0, ad.zipCode, '')) ELSE concat(IFNULL(ad1.street, ''), ' ', IF(ad1.zipCode > 0, ad1.zipCode, '')) END AS addressData,"
							+ " s.duration, sd.items " + " FROM sales s "
							+ " INNER JOIN contact_master c on c.id = s.contact_id and c.deleted = 0 "
							+ " INNER JOIN sale_driver_details sdd on sdd.sales_id = s.id and sdd.deleted = 0  "
							+ " INNER JOIN contact_master cm on cm.id = sdd.contactId and cm.deleted = 0 INNER JOIN payment_master pm on pm.contactId = sdd.contactId and pm.billId = s.id and pm.deleted = 0 "
							+ " LEFT JOIN (select * from address where id in (select max(id) from address group by  foreignKey)) AS ad ON s.id=ad.foreignKey AND ad.moduleName='SALES_SHIPPING_ADDRESS' "
							+ " LEFT JOIN (select * from address where id in (select max(id) from address group by  foreignKey)) AS ad1 ON s.contact_id=ad1.foreignKey AND ad1.moduleName='CONTACT_BILLING_ADDRESS' "
							+ " LEFT JOIN (select sd.sales_id, GROUP_CONCAT(im.name SEPARATOR ',') as items from sales_details sd LEFT JOIN item_master im on im.id = sd.item_id and im.deleted = 0  "
							+ " WHERE sd.deleted = 0 GROUP BY sd.sales_id) as sd on sd.sales_id = s.id ");
			query.append(" WHERE s.deleted = 0 ");

			if (startDateFilter) {
				query.append(" AND pm.transactionDate >= ? ");
			}

			if (endDateFilter) {
				query.append(" AND pm.transactionDate <= ? ");
			}
			if (contactFilter) {
				query.append(" AND cm.id = ? ");
			}
			// groupBy.append(" GROUP BY pm.id ");
			// query.append(groupBy);
			query.append(" ORDER BY pm.transactionDate ");
			connection = itemService.getConnection();
			statement = connection.prepareStatement(query.toString());
			if (startDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
			}

			if (endDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
			}
			if (contactFilter) {
				statement.setLong(++count, reportsData.getContactId());
			}
			resultSet = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public ResultSet getThirdPartyDetails(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean endDateFilter = false;
		boolean contactFilter = false;
		int count = 0;
		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			endDateFilter = reportsData.getEndDateTime() != null ? true : false;
			contactFilter = reportsData.getContactId() > 0;
			query.append(
					" SELECT s.id, DATE_FORMAT(pm.transactionDate,'%d/%m/%Y') as transactionDate, if(pm.cr_dr_flag=1, pm.amount, 0) AS creditAmount, if(pm.cr_dr_flag=2, pm.amount, 0) AS debitAmount,concat(IFNULL(c.fname,''), '', IFNULL(c.lname,'')) AS name, concat(IFNULL(ad.street,''), ' ', IF(ad.zipCode > 0, ad.zipCode ,'')) AS addressData, s.duration, sd.items, stp.noOfPerson as staff "
							+ "FROM sales s " + " INNER JOIN contact_master c on c.id = s.contact_id and c.deleted = 0 "
							+ " INNER JOIN sales_third_party stp ON stp.sales_id = s.id AND stp.deleted = 0 "
							+ " INNER JOIN contact_master cm on cm.id = stp.contactId and cm.deleted = 0 INNER JOIN payment_master pm on pm.contactId = stp.contactId and pm.billId = s.id and pm.deleted = 0 "
							+ " LEFT JOIN (select * from address where id in (select max(id) from address group by  foreignKey)) AS ad ON s.id=ad.foreignKey AND ad.moduleName='SALES_SHIPPING_ADDRESS' "
							+ " LEFT JOIN (select sd.sales_id, GROUP_CONCAT(im.name SEPARATOR ',') as items from sales_details sd LEFT JOIN item_master im on im.id = sd.item_id and im.deleted = 0  "
							+ " WHERE sd.deleted = 0 GROUP BY sd.sales_id) as sd on sd.sales_id = s.id ");
			query.append(" WHERE s.deleted = 0 ");

			if (startDateFilter) {
				query.append(" AND pm.transactionDate >= ? ");
			}

			if (endDateFilter) {
				query.append(" AND pm.transactionDate <= ? ");
			}
			if (contactFilter) {
				query.append(" AND cm.id = ? ");
			}
			// groupBy.append(" GROUP BY pm.id ");
			// query.append(groupBy);
			query.append(" ORDER BY pm.transactionDate ");
			connection = itemService.getConnection();
			statement = connection.prepareStatement(query.toString());
			if (startDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
			}

			if (endDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
			}
			if (contactFilter) {
				statement.setLong(++count, reportsData.getContactId());
			}
			resultSet = statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public Double getTotalPreBalance(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean contactFilter = false;
		boolean contactCategoryFilter = false;
		int count = 0;

		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			contactFilter = reportsData.getContactId() > 0;
			contactCategoryFilter = reportsData.getContactCategoryId() > 0;
			if (startDateFilter) {
				query.append(
						"SELECT sum(if(pm.cr_dr_flag=1,pm.amount, 0)) as totalCredit ,sum(if(pm.cr_dr_flag=2,pm.amount, 0)) as totalDebit ");
				query.append(
						" FROM payment_master as pm JOIN contact_master AS cm ON pm.contactId=cm.id LEFT JOIN address as ad ON cm.id=ad.foreignKey LEFT JOIN sales as sa ON sa.contact_id=cm.id ");

				query.append(" WHERE pm.deleted=0 AND cm.deleted=0 ");

				if (startDateFilter) {
					query.append(" AND pm.transactionDate < ? ");
				}
				if (contactFilter) {
					query.append(" AND cm.id = ? ");
				}
				if (contactCategoryFilter) {
					query.append(" AND cm.contact_category_id = ? ");
				}
				// groupBy.append(" GROUP BY pm.id,pm.amount ");
				query.append(groupBy);

				connection = itemService.getConnection();
				statement = connection.prepareStatement(query.toString());
				if (startDateFilter) {
					statement.setString(++count,
							DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
				}
				if (contactFilter) {
					statement.setLong(++count, reportsData.getContactId());
				}
				if (contactCategoryFilter) {
					statement.setLong(++count, reportsData.getContactCategoryId());
				}
				resultSet = statement.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Double totalPreBalance = 0.0;
		if (resultSet != null) {
			try {
				if (resultSet.next()) {
					totalPreBalance = resultSet.getDouble("totalCredit") - resultSet.getDouble("totalDebit");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return totalPreBalance;

	}

	@Override
	public ResultSet getRowPurchaseReportDetails(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean endDateFilter = false;
		boolean contactFilter = false;
		int count = 0;
		String orderType = OrderTypeItemConstant.ROW_MATERIAL.getValue();
		boolean orderTypeFilter = false;
		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			endDateFilter = reportsData.getEndDateTime() != null ? true : false;
			orderTypeFilter = orderType != null && orderType.length() > 0 ? true : false;
			contactFilter = reportsData.getContactId() > 0;
			query.append(
					"select im.name, concat(IFNULL(cm.fname,''), '', IFNULL(cm.lname,'')) AS customerName, sum(IFNULL(pd.order_quantity,0)) as quantity, sum(IFNULL(pd.return_quantity,0)) as return_quantity from item_master im inner join purchase_details pd on pd.item_id = im.id AND pd.deleted = 0  INNER JOIN purchase p on p.id = pd.purchase_id and p.deleted = 0  INNER JOIN contact_master cm ON cm.id = p.contact_id AND cm.deleted = 0");

			where.append(" and im.deleted = 0 ");

			if (startDateFilter) {
				where.append(" AND p.purchase_date >= ? ");
			}

			if (endDateFilter) {
				where.append(" AND p.purchase_date <= ? ");
			}
			if (orderTypeFilter) {
				where.append(" AND im.order_type = ? ");
			}
			if (contactFilter) {
				where.append(" AND cm.id = ? ");
			}
			query.append(where);

			groupBy.append("  GROUP BY im.id,im.name,p.contact_id having sum(IFNULL(pd.order_quantity,0)) > 0 ");
			query.append(groupBy);

			connection = itemService.getConnection();
			statement = connection.prepareStatement(query.toString());
			if (startDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
			}

			if (endDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
			}
			if (orderTypeFilter) {
				statement.setString(++count, orderType);
			}

			if (contactFilter) {
				statement.setLong(++count, reportsData.getContactId());
			}
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public ResultSet getPendingPaymentReportDetails(NewReportsData reportsData) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder query = new StringBuilder();
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		StringBuilder groupBy = new StringBuilder("");
		boolean startDateFilter = false;
		boolean endDateFilter = false;
		int count = 0;
		try {
			startDateFilter = reportsData.getStartDateTime() != null ? true : false;
			endDateFilter = reportsData.getEndDateTime() != null ? true : false;
			query.append(
					"SELECT DATE_FORMAT(s.order_date,'%d/%m/%Y') as order_date,DATE_FORMAT(s.booking_date,'%d/%m/%Y') as booking_Date, concat(IFNULL(cm.fname,''), ' ', IFNULL(cm.lname,'')) as name, cm.mobile,concat(IFNULL(ad.street, ''), ' ', IF(ad.zipCode > 0, ad.zipCode, '')) as addressData,sum(if(pm.cr_dr_flag=1,pm.amount, 0)) as totalCredit,sum(if(pm.cr_dr_flag=2,pm.amount, 0)) as totalDebit,(sum(if(pm.cr_dr_flag=2,pm.amount, 0)) - sum(if(pm.cr_dr_flag=1,pm.amount, 0))) as pendingBalance "
							+ " FROM sales s INNER JOIN contact_master cm ON cm.id = s.contact_id  and cm.deleted = 0 INNER JOIN payment_master as pm on pm.contactId = cm.id and s.id = pm.billNo and pm.deleted = 0 LEFT JOIN (select * from address where id in (select max(id) from address group by  foreignKey)) AS ad ON s.contact_id=ad.foreignKey AND ad.moduleName='CONTACT_BILLING_ADDRESS' ");
			where.append(" AND s.deleted = 0 and s.orderType = 1");
			if (startDateFilter) {
				where.append(" AND s.order_date >= ? ");
			}
			if (endDateFilter) {
				where.append(" AND s.order_date <= ? ");
			}
			query.append(where);
			groupBy.append(
					"  GROUP BY s.id, cm.fname, cm.lname, cm.mobile, ad.street, ad.zipCode HAVING (sum(if(pm.cr_dr_flag=2,pm.amount, 0)) - sum(if(pm.cr_dr_flag=1,pm.amount, 0))) > 0  ");
			query.append(groupBy);
			query.append(" ORDER BY s.order_date desc ");
			connection = itemService.getConnection();
			statement = connection.prepareStatement(query.toString());
			if (startDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
			}
			if (endDateFilter) {
				statement.setString(++count, DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
			}
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	/*
	 * @Override public ResultSet getWholeSaleReportDetails(NewReportsData
	 * reportsData) { ResultSet resultSet = null; PreparedStatement statement =
	 * null; Connection connection = null; StringBuilder query = new
	 * StringBuilder(); StringBuilder where = new StringBuilder(" WHERE 1=1 ");
	 * StringBuilder orderBy = new StringBuilder(""); boolean startDateFilter =
	 * false; boolean endDateFilter = false; int count = 0; try { startDateFilter =
	 * reportsData.getStartDateTime() != null ? true : false; endDateFilter =
	 * reportsData.getEndDateTime() != null ? true : false; query.
	 * append("select DATE_FORMAT(s.order_date,'%d/%m/%Y') as order_date, sd.item_id, im.name, sd.total_price, sd.price, sd.order_quantity from sales s inner JOIN sales_details sd on sd.sales_id = s.id and sd.deleted = 0 inner join item_master im on im.id = sd.item_id and im.deleted = 0 inner join contact_master cm on cm.id = s.contact_id and cm.deleted = 0 "
	 * ); where.append(" and s.deleted = 0  and s.orderType = 2 "); if
	 * (startDateFilter) { where.append(" AND s.order_date >= ? "); } if
	 * (endDateFilter) { where.append(" AND s.order_date <= ? "); }
	 * query.append(where); orderBy.append("  order by s.order_date, sd.item_id ");
	 * query.append(orderBy); connection = itemService.getConnection(); statement =
	 * connection.prepareStatement(query.toString()); if (startDateFilter) {
	 * statement.setString(++count,
	 * DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime())); } if
	 * (endDateFilter) { statement.setString(++count,
	 * DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime())); }
	 * resultSet = statement.executeQuery(); } catch (SQLException e) {
	 * e.printStackTrace(); } return resultSet; }
	 */

	public Connection getReportConnection(NewReportsData reportsData) {
		return itemService.getConnection();
	}
}
