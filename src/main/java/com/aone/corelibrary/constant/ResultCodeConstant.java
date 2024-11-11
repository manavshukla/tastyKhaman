package com.aone.corelibrary.constant;

import java.util.HashMap;
import java.util.Map;

public enum ResultCodeConstant {
	
	/*************************************************************
	 * SUCCESS CODES- starts from 2000 to 2999                   *
	 *************************************************************/
	SUCCESS(2200, "Success"),
	
	
	/*************************************************************
	 * REDIRECT OR OTHER SERVER CODES - starts from 3000 to 3999 *
	 * ***********************************************************/
	REDIRECT(3302, "Internal server error"),
	
	
	/*************************************************************
	 * VALIDATION OR PROCESSING CODES- starts from 4000 to 4999  *
	 * ***********************************************************/
	UNAUTHORIZED(401, "Unauthorized"),
	FORBIDDEN(403, "Forbidden"),
	
	PARAMETER_NOT_FOUND(4404, "Parameter value not found"),
	
	// ITEM related result codes - > 01
	ITEM_CODE_NOT_FOUND(4404011, "Item code not found"),
	ITEM_CODE_ALREADY_EXIST(4404012, "Item code already exist"),
	ITEM_CATEGORY_REQURIED(4404013, "Item category is required"),
	ITEM_UOM_REQURIED(4404014, "Item UOM is required"),
	ITEM_PURCHASE_GST_RATE_REQURIED(4404015, "Item purchase GST Rate is required"),
	ITEM_PURCHASE_GT_ZERO(4404016, "Item purchase price is required"),
	ITEM_SALE_GT_ZERO(4404017, "Item sales price is required"),
	ITEM_SALE_GST_RATE_REQURIED(4404018, "Item sale GST Rate is required"),
	ITEM_ROL_GT_ZERO(4404019, "Item reorder level is required"),
	
		
	// ITEM_CATEGORY result codes- > 02
	ITEM_CATEGORY_NAME_NOT_FOUND(4404021, "Category name not found"),
	ITEM_CATEGORY_NAME_ALREADY_EXIST(4404022, "Category name already exist"),
	
	// UOM result codes- > 03
	UOM_NAME_NOT_FOUND(4404031, "UOM name not found"),
	UOM_NAME_ALREADY_EXIST(4404032, "UOM name already exist"),
	
	// GST RATE RELATED RESULT CODES - > 04
	GST_RATE_NAME_ALREADY_EXIST(4404041, "GST rate name already exist"),
	GST_RATE_GT_ZERO(4404042, "GST rate percentage is required"),
	
	
	// State related result codes - > 05
	COUNTRY_NAME_NOT_FOUND(4404051, "Country name not found"),
	COUNTRY_NAME_ALREADY_EXIST(4404052, "Country name already exist"),
		
	// State related result codes - > 06
	STATE_NAME_NOT_FOUND(4404061, "State name not found"),
	STATE_NAME_ALREADY_EXIST(4404062, "State name already exist"),
	STATE_COUNTRY_DETAILS_MISSING(4404063, "Country details required"),
	STATE_CODE_GT_ZERO(4404064, "State code is required"),
	STATE_CODE_ALREADY_EXIST(4404065, "State code already exist"),
	
	// State related result codes - > 07
	CITY_NAME_NOT_FOUND(4404071, "City name not found"),
	CITY_NAME_ALREADY_EXIST(4404072, "City name already exist"),
	CITY_STATE_REQUIRED(4404073, "State details required"),
	
	// State related result codes - > 08
	ADDRESS_COUNTRY_CODE_NOT_FOUND(4404081, "Address country not found"),
	ADDRESS_STATE_CODE_NOT_FOUND(4404082, "Address  state not found"),
	ADDRESS_CITY_CODE_NOT_FOUND(4404083, "Address  city not found"),
	ADDRESS_FOREIGN_KEY_NOT_FOUND(4404084, "Address mapping not found"),
	ADDRESS_MOUDLE_NAME_NOT_FOUND(4404085, "Address module name not found"),
	
	// CONTACT_CATEGORY result codes- > 09
	CONTACT_CATEGORY_NAME_NOT_FOUND(4404091, "Contact category name not found"),
	CONTACT_CATEGORY_NAME_ALREADY_EXIST(4404092, "Contact category name already exist"),
	
	// CONTACT_OTHER_DETAILS result codes- > 10
	CONTACT_OTHER_DETAILS_CONTACT_GT_ZERO(4404101, "Contact details are required"),

	// CONTACT_OTHER_DETAILS result codes- > 11
	CONTACT_BANK_DETAILS_CONTACT_GT_ZERO(4404111, "Contact bank details are required"),
	
	// FILES_DATA result codes- > 12
	FILES_DATA_FOREIGN_KEY_NOT_FOUND(4404081, "Files data mapping not found"),
	FILES_DATA_MOUDLE_NAME_NOT_FOUND(4404081, "Files Data module name not found"),
	
	
	// ITEM related result codes - > 13
	ITEM_SIZE_NOT_FOUND(4404131, "Item size not found"),
	ITEM_SIZE_ALREADY_EXIST(4404132, "Item size already exist"),
	
	// ITEM related result codes - > 14
	ITEM_SCHEME_NAME_NOT_FOUND(4404141, "Item scheme name not found"),
	ITEM_SCHEME_NAME_ALREADY_EXIST(4404142, "Item scheme name already exist"),
	ITEM_SCHEME_ITEM_REQURIED(4404143, "Item scheme item is required"),
	ITEM_SCHEME_UOM_REQURIED(4404144, "Item UOM is required"),
	ITEM_SCHEME_SALE_GT_ZERO(4404147, "Item sales price is required"),
	ITEM_SCHEME_SALE_GST_RATE_REQURIED(4404148, "Item sale GST Rate is required"),
	
	//SALE_ORDER_SERVICE result codes -> 12
		SALE_ORDER_SERVICE_APPOINTMENT_ID(4404121, "Sale Order services Appointment Id is required"),
		SALE_ORDER_SERVICE_SERVICES_ID(4404122, "Sale Order services Service Id is required"),
		SALE_ORDER_SERVICE_MECHANIC_ID (4404123, "Sale Order services Mechanic Id is required"),
		SALE_ORDER_SERVICE_SALE_ORDER_ID (4404124, "Sale Order services Sale Order Id is required"),
		
		//EMPLOYEE result codes -> 13
		EMPLOYEE_FIRST_NAME(4404131, "Employee First name is required"),
		EMPLOYEE_LAST_NAME(4404132, "Employee Last name is required"),
		EMPLOYEE_MIDDLE_NAME(4404133, "Employee Middle name is required"),
		EMPLOYEE_DATE_OF_JOIN(4404134, "Employee Date of Join is required"),
		EMPLOYEE_ADDRESS_1(4404135, "Employee Address 1 is required"),
		EMPLOYEE_DATE_OF_BIRTH(4404136, "Employee Date of birth is required"),
		EMPLOYEE_DESIGNATION(4404137, "Employee Designation is required"),
		EMPLOYEE_ADDRESS_2(4404138, "Employee Address 2 is required"),

		//APPOINTMENT_ORDER_DETAILS result codes -> 14
		APPOINTMENT_ORDER_DETAILS_CONTACT_ID(4404140, "Apointment Order details Contact ID is required"),
		APPOINTMENT_ORDER_DETAILS_DATE_TIME_OF_APPT(4404141, "Apointment Order details Date of Appointment Creation is required"),
		APPOINTMENT_ORDER_DETAILS_CONTACT_VEHICLE_DETAILS_ID(4404142, "Apointment Order details Contact Vehicle Details Id is required"),
		APPOINTMENT_ORDER_DETAILS_SUPERVISOR_ID(4404143, "Apointment Order details Supervisor Id is required"),
		APPOINTMENT_ORDER_DETAILS_CREATED_BY_ID(4404144, "Apointment Order details created by Id is required"),
		APPOINTMENT_ORDER_DETAILS_PICKUP_DRIVER_ID(4404145, "Apointment Order details Pick up Driver id is required"),
		APPOINTMENT_ORDER_DETAILS_PICKUP_DATE_TIME(4404146, "Apointment Order details Pick up date time is required"),
		APPOINTMENT_ORDER_DETAILS_DROP_DRIVER_ID(4404147, "Apointment Order details Drop Driver Id is required"),
		APPOINTMENT_ORDER_DETAILS_DROP_DATE_TIME(4404148, "Apointment Order details Drop date time is required"),
		//SERVICE_CATEGORY result codes -> 15
		SERVICE_CATEGORY_DESCRIPTION(4404151, "Service Category Description is required"),
		SERVICE_CATEGORY_NAME(4404152, "Service Category, Name is required"),
		SERVICE_CATEGORY_PARENT_CATEGORY_ID(4404153, "Service Category Parent Category Id is required"),
		//VEHICLE_INSURANCE_POLICY result codes -> 16
		VEHICLE_INSURANCE_POLICY_POLICY_NO(4404161, "Vehicle Insurance Policy, Policy number is required"),
		VEHICLE_INSURANCE_POLICY_VEHICLE_ID(4404162, "Vehicle Insurance Policy Vehicle Id is required"),
		VEHICLE_INSURANCE_POLICY_START_DATE(4404163, "Vehicle Insurance Policy Start Date is required"),
		VEHICLE_INSURANCE_POLICY_END_DATE(4404164, "Vehicle Insurance Policy End Date is required"),
		VEHICLE_INSURANCE_POLICY_INSURANCE_COMPANY(4404165, "Vehicle Insurance Policy Insurance Company is required"),
		VEHICLE_INSURANCE_POLICY_TOTAL_INSURED_AMOUNT(4404166, "Vehicle Insurance Policy Total Insured amount is required"),
		//VEHICLE_CLAIM_DETAIL result codes -> 17
		VEHICLE_CLAIM_DETAIL_SALES_ORDER_ID(4404171, "Vehicle Claim Detail Sales order Id is required"),
		VEHICLE_CLAIM_DETAIL_VEHICLE_INSURANCE_POLICY_ID(4404172, "Vehicle Claim Detail Vehicle Insurance policy id is required"),
		VEHICLE_CLAIM_DETAIL_CLAIMED_AMOUNT(4404173, "Vehicle Claim Detail Claimed Amount is required"),
		VEHICLE_CLAIM_DETAIL_PASSED_AMOUNT(4404174, "Vehicle Claim Detail Passed Amount is required"),
		VEHICLE_CLAIM_DETAIL_DATE(440417, "Vehicle Claim Detail Date is required"),
		//SERVICE_PACKAGE_MASTER result codes -> 18
		SERVICE_PACKAGE_MASTER_NAME(4404181, "Service Package master Name is required"),
		SERVICE_PACKAGE_MASTER_TOTAL_AMOUNT(4404182, "Service Package master Total Amount is required"),
		SERVICE_PACKAGE_MASTER_TOTAL_SERVICES(4404183, "Service Package master Total Service is required"),
		SERVICE_PACKAGE_MASTER_PACKAGE_VALIDITY(4404184, "Service Package master Validity is required"),
		//SERVICE_PACKAGE_DETAIL result codes -> 19
		SERVICE_PACKAGE_DETAIL_PARENT_ID(4404191, "Service Package detail Parent Id is required"),
		SERVICE_PACKAGE_DETAIL_SERVICE_ID(4404192, "Service Package detail Service Id is required"),
		SERVICE_PACKAGE_DETAIL_SERVICE_COUNT(4404193, "Service Package detail Service Count is required"),
		//CONTACT_VEHICLE result codes -> 20
		CONTACT_VEHICLE_REGISTRATION_NO(4404201, "Contact Vehice Registration Number is required"),
		CONTACT_VEHICLE_CONTACT_ID(4404202, "Contact Vehice Contact Id is required"),
		CONTACT_VEHICLE_AMC_REGISTRATION_DATE(4404203, "Contact Vehice Registration date is required"),
		CONTACT_VEHICLE_MODEL_NO(4404204, "Contact Vehice Model No. is required"),
		CONTACT_VEHICLE_BRAND_NAME(4404205, "Contact Vehice Brand Name is required"),
		CONTACT_VEHICLE_YEAR_OF_MANUFACTURE(4404206, "Contact Vehice Year of Manufacture is required"),
		//SERVICE result codes -> 21
		SERVICE_NAME(4404211, "Service Name is required"),
		SERVICE_CATEGORY_ID(4404212, "Service Category ID is required"),
		SERVICE_PRICE(4404213, "Service Price is required"),
		SERVICE_DURATION(4404214, "Service Duration is required"),
		//SALE_ORDER result codes -> 22
		SALE_ORDER_APPOINTMENT_ID(4404221, "Sale Order Appointment Id is required"),
		SALE_ORDER_CONTACT_ID(4404222, "Sale Order Contact Id is required"),
		SALE_ORDER_ORDER_DATE(4404223, "Sale Order date is required"),
		
		// COMPANY result codes- > 23
		ITEM_COMPANY_NAME_NOT_FOUND(4404231, "Company name not found"),
		ITEM_COMPANY_NAME_ALREADY_EXIST(4404232, "Company name already exist"),
		
		// Purchase result costant -> 44
		USER_ROLE_NAME_NOT_FOUND(4404441, "User role name not found"),
		USER_ROLE_NAME_ALREADY_EXIST(4404442, "User role name already exist"),
		// ITEMSIZE result codes- > 24
		ITEM_ITEMSIZE_NAME_NOT_FOUND(4404241, "Itemsize name not found"),
		ITEM_ITEMSIZE_NAME_ALREADY_EXIST(4404242, "Itemsize name already exist"),
		FILES_DATA_MOUDLE_NAME_WRONG(4404123, "Files Data module name is wrong"),
	/*************************************************************
	 * INTERNAL SERVER CODES - starts from 5000 to 5999  *
	 * ***********************************************************/
	INTERNAL_ERROR(5500, "Internal server error"),
	NETWORK_AUTHENTICATION_REQUIRED(5511, "Network Authentication Required"), ;
	;
	
	private Integer resultCode;
	private String message;
	
	private static Map<Integer, ResultCodeConstant> codeWiseResultCodeMap  = new HashMap<>();
	
	static {
		ResultCodeConstant codeConstant = null;
		for(ResultCodeConstant resultCodeConstant : values()) {
			codeConstant = codeWiseResultCodeMap.get(resultCodeConstant.getResultCode());
			if(codeConstant != null) {
				System.out.println("Apllication can not be started as resulcodes are duplicate");
			}
		}
	}
	
	private ResultCodeConstant(Integer resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public String getMessage() {
		return message;
	}

	public static ResultCodeConstant getResultCodeConstant(Integer resultCode) {
		return codeWiseResultCodeMap.get(resultCode);
	}
	
}
