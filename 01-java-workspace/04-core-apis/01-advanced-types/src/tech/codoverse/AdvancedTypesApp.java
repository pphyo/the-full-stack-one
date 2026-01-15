package tech.codoverse;

import static java.lang.IO.println;

import java.util.Arrays;

import tech.codoverse.annotation.AnnotationResult;
import tech.codoverse.annotation.UsingAnnotation;
import tech.codoverse.enumeration.Calendar;
import tech.codoverse.enumeration.Operator;
import tech.codoverse.enumeration.Season;
import tech.codoverse.record.ImmutableData;
import tech.codoverse.record.MutableData;
import tech.codoverse.record.Point;

public class AdvancedTypesApp {

	void main() {
		try {
			var ua = new UsingAnnotation();
			AnnotationResult.generate(ua);
			
			IO.println(ua.getValueOne());
			IO.println(ua.getValueTwo());
			IO.println(ua.getNothing());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void runForRecord() {
		var point = new Point(0, 0);
		println(point.x());
		println(point.y());
		println(point);
	}

	void runForImmutable() {
		var data = new ImmutableData(10);
		println(data);
	}

	void runForMutable() {
		var data = new MutableData(10);
		println(data);
		data.setData(20);
		println(data);
	}

	void runForOperator() {
		int a = 15;
		int b = 5;

		var operators = Operator.values();
		for (var ope : operators) {
			println("%d %s %d = %d".formatted(a, ope.sign(), b, ope.apply(a, b)));
		}
	}

	// parse
	// valueOf
	// to<>
	void runForEnum() {
		// Season season = Season.FALL;
		// println(season);
		// println(season.name());
		// println(season.ordinal());

		Season[] values = Season.values();
		println(Arrays.toString(values));

		Season season = Season.valueOf("FALL");
		println(season);
		println(season.name());
		println(season.ordinal());
		println(season.traffic());
		println(season.minimum());
	}

	void runBeforeEnum() {
		Calendar cal = new Calendar();
		cal.setSeason(Season.FALL);
	}

}