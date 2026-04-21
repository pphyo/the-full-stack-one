module calendar.provider {
	
	requires calendar.api;
	
	provides com.myanmar.calendar.api.HolidayProvider 
		with com.myanmar.calendar.provider.MyanmarHolidays;
	
}