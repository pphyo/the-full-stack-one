package tech.codoverse;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class BuiltInFunctionalInterface {
	
	void main() {
		runForPredicate();
	}
	
	void runForPredicate() {
		Predicate<Integer> positive = i -> i > 0;
		Predicate<Integer> zero = i -> i == 0;
		Predicate<Integer> even = i -> i % 2 == 0;
		
		boolean result = positive.or(even).and(zero.negate()).test(33);
		
		IO.println(result);
		
	}
	
	void runForConsumer() {
		Consumer<String> hello = str -> IO.println("Hello, " + str);
		Consumer<String> hi = str -> IO.println("Hi, " + str);
		
		hello.andThen(hi).andThen(hello).accept("Hopkins");
	}
	
	void runForFunction() {
		Function<Integer, Integer> twice = i -> i * 2;
		Function<Integer, Integer> square = i -> i * i;
		
		int result = twice.compose(twice).andThen(twice).compose(square).apply(3);
		
		IO.println(result);
		
	}

}
