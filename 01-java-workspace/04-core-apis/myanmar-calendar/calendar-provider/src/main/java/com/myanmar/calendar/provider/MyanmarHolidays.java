package com.myanmar.calendar.provider;

import java.util.List;

import com.myanmar.calendar.api.HolidayProvider;

public class MyanmarHolidays implements HolidayProvider {
	
	@Override
	public String getCountryName() {
		return "Myanmar";
	}
	
	@Override
	public List<String> getHolidays() {
		return List.of("Independence Day", "Thinggyin", "Thadingyut");
	}

}
