package com.aone.corelibrary.model.impl;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Default and complete implementation of the {@link IPaginator} interface.
 * 
 * @author Bharat Tulsiyani
 *
 */
public class PaginationData implements Serializable {

	private static final long serialVersionUID = 8519041666659775455L;
	
	private Integer rowsPerPage;
	private Integer pageNumber;
	private LinkedList<OrderingData> orderingDataList;
	
	public PaginationData() {
		this.pageNumber = 1;
		this.rowsPerPage = 10;
		this.orderingDataList = new LinkedList<>();
	}

	public Integer getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public LinkedList<OrderingData> getOrderBy() {
		return orderingDataList;
	}

	public void setOrderBy(LinkedList<OrderingData> orderingDataList) {
		this.orderingDataList = orderingDataList;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	@Override
	public String toString() {
		return "DefaultPaginator [rowsPerPage=" + rowsPerPage + ", pageNumber="
				+ pageNumber + ", orderingDataList=" + orderingDataList + "]";
	}

}
