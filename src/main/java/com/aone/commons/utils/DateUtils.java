package com.aone.commons.utils;

import java.time.LocalDateTime;

import com.aone.commons.ConfigConstant;

public class DateUtils {
	
	public static String getUIDateFormatted(LocalDateTime localDateTime) {
		if(localDateTime == null) {
			return "";
		}
		return ConfigConstant.UI_DATE_FORMATTER.format(localDateTime);
	}
	
	public static String getUIDateTimeFormatted(LocalDateTime localDateTime) {
		if(localDateTime == null) {
			return "";
		}
		return ConfigConstant.UI_DATE_TIME_FORMATTER.format(localDateTime);
	}
	
	public static String getMySqlDbDateTimeFormatted(LocalDateTime localDateTime) {
		if(localDateTime == null) {
			return "";
		}
		return ConfigConstant.MYSQL_DB_FORMATTER.format(localDateTime);
	}
	
	public static String getMySqlDbStartDateFormatted(LocalDateTime localDateTime) {
		if(localDateTime == null) {
			return "";
		}
		localDateTime = localDateTime.withHour(0);
		localDateTime = localDateTime.withMinute(0);
		localDateTime = localDateTime.withSecond(0);
		localDateTime = localDateTime.withNano(0);
		return ConfigConstant.MYSQL_DB_FORMATTER.format(localDateTime);
	}
	
	public static String getMySqlDbEndDateFormatted(LocalDateTime localDateTime) {
		if(localDateTime == null) {
			return "";
		}
		localDateTime = localDateTime.withHour(23);
		localDateTime = localDateTime.withMinute(59);
		localDateTime = localDateTime.withSecond(59);
		localDateTime = localDateTime.withNano(999);
		return ConfigConstant.MYSQL_DB_FORMATTER.format(localDateTime);
	}

    public static LocalDateTime formateDateOnly(LocalDateTime localDateTime) {
        if(localDateTime == null) {
            return localDateTime;
        }
        localDateTime = localDateTime.withHour(0);
        localDateTime = localDateTime.withMinute(0);
        localDateTime = localDateTime.withSecond(0);
        localDateTime = localDateTime.withNano(0);
        return localDateTime;
    }
}
