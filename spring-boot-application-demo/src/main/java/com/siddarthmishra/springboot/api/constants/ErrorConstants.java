package com.siddarthmishra.springboot.api.constants;

import java.util.List;

public interface ErrorConstants extends CommonConstants {

	public static final String REQ_PARAM_EXP_FRM_CD_001 = "INV_REQ_PARAM_EXP_FRM_001";
	public static final String REQ_PARAM_EXP_FRM_MSG_001 = "The provided value '%s' for the query param 'expiryFrom' is invalid. The acceptable format is "
			+ CommonConstants.YYYYMMDD;
	public static final String REQ_PARAM_EXP_TO_CD_001 = "INV_REQ_PARAM_EXP_TO_001";
	public static final String REQ_PARAM_EXP_TO_MSG_001 = "The provided value '%s' for the query param 'expiryTo' is invalid. The acceptable format is "
			+ CommonConstants.YYYYMMDD;
	public static final String REQ_PARAM_EXP_FRM_EXP_TO_CD_001 = "REQ_PARAM_EXP_FRM_EXP_TO_001";
	public static final String REQ_PARAM_EXP_FRM_EXP_TO_MSG_001 = "Either of the query param 'expiryFrom' or 'expiryTo' is missing";
	public static final String REQ_PARAM_EXP_FRM_EXP_TO_CD_002 = "REQ_PARAM_EXP_FRM_EXP_TO_002";
	public static final String REQ_PARAM_EXP_FRM_EXP_TO_MSG_002 = "The query param 'expiryFrom' is after 'expiryTo'. Consider switching the values";
	public static final String REQ_PARAM_EXP_FRM_EXP_TO_CD_003 = "REQ_PARAM_EXP_FRM_EXP_TO_003";
	public static final String REQ_PARAM_EXP_FRM_EXP_TO_MSG_003 = "The time interval between 'expiryFrom' and 'expiryTo' is greater than 90 days. The allowed search interval is within 90 days";
	public static final String REQ_PARAM_SORT_BY_CD_001 = "INV_REQ_PARAM_SORT_BY_001";
	public static final String REQ_PARAM_SORT_BY_MSG_001 = "The value of the query param 'orderByExpiry' should either be 'ASC' or 'DESC'. This is case insensitive";
	public static final String INVALID_DATE_FORMAT_CD_001 = "INVALID_DATE_FORMAT_001";
	public static final String INVALID_DATE_FORMAT_MSG_001 = "The provided date '%s' is invalid. The acceptable date format is %s";
	public static final String REQ_PARAM_USER_SEARCH_CD_001 = "INV_REQ_PARAM_USER_SEARCH_001";
	public static final List<String> USER_SEARCH_REQ_PARAM_LIST = List.of("emailId", "userId");
	public static final String REQ_PARAM_USER_SEARCH_MSG_001 = "The required query parameters for User search are either missing or invalid. Please provide at-least one of "
			+ USER_SEARCH_REQ_PARAM_LIST + ".";
	public static final String EMAIL_ID_REGISTERED_CD_001 = "EMAIL_ID_REGISTERED_CD_001";
	public static final String EMAIL_ID_REGISTERED_MSG_001_FORMAT = "The provided email ID %s is already registered. Please provide an email ID which is not registered.";
}
