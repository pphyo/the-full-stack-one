package com.codoverse.cf;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<LocalDate> {
	
	private DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	@Override
	public String print(LocalDate object, Locale locale) {
		return DF.format(object);
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		return LocalDate.parse(text, DF);
	}

}
