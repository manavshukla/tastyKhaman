package com.aone.module.sales.util;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aone.commons.ModuleName;
import com.aone.module.address.model.Address;
import com.aone.module.address.service.IAddressService;
import com.aone.module.address.util.AddressUtil;
import com.aone.module.city.service.ICityService;
import com.aone.module.contact.model.Contact;
import com.aone.module.country.service.ICountryService;
import com.aone.module.sales.constant.SalesOrderTypeEnum;
import com.aone.module.sales.model.Sales;
import com.aone.module.salesDriverDetails.model.SaleDriverDetails;
import com.aone.module.state.service.IStateService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SalesUtil {
	
	private SalesUtil() {
		throw new IllegalStateException("Util class");
	}
	
	public static Map<String,Object> getParamesterForPrintBill(Sales sales, IAddressService addressService, ICityService cityService, IStateService stateService, ICountryService countryService){
		Map<String,Object> params = new HashMap<>();
		List<SaleDriverDetails> driverDetailsList;
		SaleDriverDetails driverDetails;
		String customerName = "";
		Contact contact;
		String strAddress = "";
		try {
			if(sales != null) {
				params.put("billNo", sales.getId());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				params.put("date",  sales.getOrderDate().format(formatter));
				contact = sales.getContact();
				if(contact != null) {
					if(contact.getFname() != null) {
						customerName = contact.getFname();
					}
					
					if(contact.getLname() != null) {
						customerName += " " + contact.getLname();
					}
					params.put("customerName", customerName);
					
					// address details
					if (sales.getOrderType() == SalesOrderTypeEnum.LIVE_FOOD_ORDER.getValue()) {
						strAddress = AddressUtil.getFullAddress(sales.getShippingAddress(), cityService, stateService, countryService);
					}
					if (sales.getOrderType() == SalesOrderTypeEnum.WHOLE_SALE_ORDER.getValue()) {
						Address billinAddress = new Address();
						billinAddress.setModuleName(ModuleName.CONTACT_BILLING_ADDRESS.getValue());
						billinAddress.setForeinKey(contact.getId());
						contact.setBillingAddress(addressService.getAddressByForeignKeyId(billinAddress));
						strAddress = AddressUtil.getFullAddress(contact.getBillingAddress(), cityService, stateService, countryService);
					}
					params.put("address", strAddress);
					params.put("mobile", contact.getMobile());
					params.put("email", contact.getEmail());
				}
				
				params.put("subTotal", sales.getNetAmount());
				params.put("discount", sales.getDiscount());
				params.put("grandTotal", sales.getGrossAmount());
				params.put("advance", sales.getAdvance());
				params.put("time", sales.getTime());
				params.put("gstNo", "24AIPPV2086A1Z6");
				driverDetailsList = sales.getSaleDriverDetails();
				if(driverDetailsList != null && driverDetailsList.size() > 0) {
					driverDetails = driverDetailsList.get(0);
					params.put("vehicleRent", driverDetails.getRate());
					params.put("vehicleNo", driverDetails.getVehicleNo());
				}
				
				JRBeanCollectionDataSource salesDetailsData = new JRBeanCollectionDataSource(sales.getSalesDetails());
				params.put("salesDetails", salesDetailsData);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}
	
}
