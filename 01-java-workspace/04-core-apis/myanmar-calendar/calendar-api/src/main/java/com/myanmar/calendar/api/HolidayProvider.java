package com.myanmar.calendar.api;

import java.util.List;

public interface HolidayProvider {
	
	String getCountryName();
	
	List<String> getHolidays();

}
