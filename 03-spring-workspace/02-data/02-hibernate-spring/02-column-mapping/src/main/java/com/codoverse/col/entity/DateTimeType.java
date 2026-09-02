package com.codoverse.col.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "date_time_types")
public class DateTimeType {
	
	@Id
	private Long id;
	
	private java.sql.Date sqlDate;
	private java.util.Date utilDate;
	private java.util.Calendar utilCalendar;
	private LocalDate localDate;
	private LocalTime localTime;
	private LocalDateTime localDateTime;
	
	private Year yearVal;
	private YearMonth yearMonthVal;
	private DayOfWeek dayOfWeekVal;
	private Month monthVal;
	private MonthDay monthDayVal;
	
	private SimpleClass simpleClazz;

}

// java.sql.Date
// java.util.Date
// java.time.LocalDate