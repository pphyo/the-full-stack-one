package com.myanmar.calendar.app;

import java.util.ServiceLoader;

import com.myanmar.calendar.api.HolidayProvider;

public class CalendarApp {
	
	void main() {
		IO.println("ရုံးပိတ်ရက်စနစ် စတင်ပါပြီ...");
		
		ServiceLoader<HolidayProvider> providers = ServiceLoader.load(HolidayProvider.class);
		
		for(HolidayProvider provider : providers) {
			IO.println(provider.getCountryName());
			IO.println(provider.getHolidays());
		}
	}

}
