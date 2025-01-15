package com.siddarthmishra.springboot.api.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.siddarthmishra.springboot.api.constants.ErrorConstants;
import com.siddarthmishra.springboot.api.exception.ApplicationException;

public interface RequestValidator extends ErrorConstants {

	public static void validateExpiryRequestParam(String expiryFrom, String expiryTo) {
		LocalDate fromDate = null;
		if (expiryFrom != null) {
			// perform validation only if value is provided
			fromDate = parse(expiryFrom, FORMATTER_YYYYMMDD, REQ_PARAM_EXP_FRM_CD_001, REQ_PARAM_EXP_FRM_MSG_001,
					HttpStatus.BAD_REQUEST, expiryFrom);
		}
		LocalDate toDate = null;
		if (expiryTo != null) {
			// perform validation only if value is provided
			toDate = parse(expiryTo, FORMATTER_YYYYMMDD, REQ_PARAM_EXP_TO_CD_001, REQ_PARAM_EXP_TO_MSG_001,
					HttpStatus.BAD_REQUEST, expiryTo);
		}
		if (fromDate == null && toDate == null) {
			return;
		}
		if ((fromDate != null && toDate == null) || (fromDate == null && toDate != null)) {
			throwApplicationException(REQ_PARAM_EXP_FRM_EXP_TO_MSG_001, REQ_PARAM_EXP_FRM_EXP_TO_CD_001,
					HttpStatus.BAD_REQUEST, null);
		}
		if (fromDate.isAfter(toDate)) {
			throwApplicationException(REQ_PARAM_EXP_FRM_EXP_TO_MSG_002, REQ_PARAM_EXP_FRM_EXP_TO_CD_002,
					HttpStatus.BAD_REQUEST, null);
		}
		if (toDate.isAfter(fromDate.plusDays(90))) {
			throwApplicationException(REQ_PARAM_EXP_FRM_EXP_TO_MSG_003, REQ_PARAM_EXP_FRM_EXP_TO_CD_003,
					HttpStatus.BAD_REQUEST, null);
		}
	}

	public static LocalDate parse(CharSequence text, DateTimeFormatter formatter, String errorCode,
			String messageFormat, HttpStatusCode httpStatusCode, Object... args) {
		LocalDate localDate = null;
		try {
			localDate = LocalDate.parse(text, formatter);
		} catch (DateTimeParseException ex) {
			String message = String.format(messageFormat, args);
			throwApplicationException(message, errorCode, httpStatusCode, ex.getMessage());
		}
		return localDate;
	}

	private static void throwApplicationException(String message, String errorCode, HttpStatusCode httpStatusCode,
			String details) {
		throw new ApplicationException(message, errorCode, httpStatusCode, details);
	}

	public static String validateSortBy(String orderByExpiry) {
		if (orderByExpiry != null) {
			if (!(ASC.equalsIgnoreCase(orderByExpiry) || DESC.equalsIgnoreCase(orderByExpiry))) {
				throwApplicationException(REQ_PARAM_SORT_BY_MSG_001, REQ_PARAM_SORT_BY_CD_001, HttpStatus.BAD_REQUEST,
						null);
			}
			orderByExpiry = ASC.equalsIgnoreCase(orderByExpiry) ? ASC : DESC;
		}
		return orderByExpiry;
	}
}
