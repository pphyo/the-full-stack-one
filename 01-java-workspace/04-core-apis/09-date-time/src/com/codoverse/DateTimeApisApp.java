package com.codoverse;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.codoverse.ts.AtomicCounter;

public class DateTimeApisApp {

	void main() {
		runForFormat();
	}
	
	void runForFormat() {
		DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		
		LocalDate date = LocalDate.now();
		
		IO.println(date.format(FORMAT));
	}
	
	void runForDuration() {
		ZoneId zone = ZoneId.of("Europe/London");
		ZonedDateTime zdt = ZonedDateTime.now(zone);
		
		IO.println(zdt.plus(Period.ofDays(1)));
		
		IO.println(zdt.plus(Duration.ofHours(24)));
	}
	
	void runForPeriod() {
		
		LocalDate birthDay = LocalDate.of(2000, 5, 11);
		LocalDate now = LocalDate.now();
		
		Period period = Period.between(birthDay, now);
				
		IO.println(period);
		
		LocalDate future = birthDay.plus(Period.ofMonths(3));
		IO.println(future);
		
	}
	
	void runForZonedDateTime() {
		var zone = ZoneId.of("Europe/London");
		var zdt = ZonedDateTime.now(zone);
		
		IO.println(zdt);
	}

	void runForLocalDateTime() {
		
		var cf = ChronoField.DAY_OF_YEAR;
		
		var date = LocalDate.of(2020, 6, 28);
		var now = LocalDate.now();
		
		IO.println(date.isSupported(cf));
		IO.println(date.isSupported(ChronoUnit.SECONDS));
		
		if(date.isSupported(cf)) {
			IO.println(date.range(cf));
			IO.println(date.get(cf));
			IO.println(date.getLong(cf));
		}
		
		IO.println(date.getChronology());
		IO.println(date.getEra());
		IO.println(date.getYear());
		
		IO.println(date.with(Year.of(2155)));
		
		IO.println(date.plus(Period.ofDays(10)));
		
		IO.println(date.query(a -> a.get(ChronoField.DAY_OF_WEEK)));
		
		IO.println(now.adjustInto(date));
		
		IO.println(date.until(now));
		
		IO.println(date.atStartOfDay());
		
		IO.println(date.toEpochDay());
		
		var period = LocalDate.of(1970, 1, 1).until(date);
		
		IO.println((period.getYears() * 12 * 31 + 27));
		
		IO.println(date);
	}

	void runForUtilDate() {
		
		IO.println(System.currentTimeMillis());
		
		Date date = new Date(System.currentTimeMillis());
		
		IO.println(date);
		
	}
	
	void runForThreadSafe() {
		try {
			var counter = new AtomicCounter();
			
			Runnable task = () -> {
				for(int i = 0; i < 1000; i++)
					counter.increment();
			};
			
			Thread t1 = new Thread(task);
			Thread t2 = new Thread(task);
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
			IO.println("Expected output: 2000");
			IO.println("Actual output: " + counter.getCount());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
