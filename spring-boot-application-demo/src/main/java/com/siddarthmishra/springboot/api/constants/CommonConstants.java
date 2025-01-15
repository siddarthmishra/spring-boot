package com.siddarthmishra.springboot.api.constants;

import java.time.format.DateTimeFormatter;

public interface CommonConstants {
	public static final String FORWARD_SLASH = "/";
	public static final String DD_MMM_YYYY = "dd-MMM-yyyy";
	public static final DateTimeFormatter FORMATTER_DD_MMM_YYYY = DateTimeFormatter.ofPattern(DD_MMM_YYYY);
	public static final String DD_MMM_YYYY_HH_MM_SS_SSS = "dd-MMM-yyyy HH:mm:ss.SSS";
	public static final DateTimeFormatter FORMATTER_DD_MMM_YYYY_HH_MM_SS_SSS = DateTimeFormatter
			.ofPattern(DD_MMM_YYYY_HH_MM_SS_SSS);
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final DateTimeFormatter FORMATTER_YYYYMMDD = DateTimeFormatter.ofPattern(YYYYMMDD);
	public static final String ASC = "ASC";
	public static final String DESC = "DESC";
}
