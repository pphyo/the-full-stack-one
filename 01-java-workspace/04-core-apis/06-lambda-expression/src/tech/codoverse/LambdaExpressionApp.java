package tech.codoverse;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaExpressionApp {
	
	void main() {
		runForUnaryOperator();
	}
	
	void runForFI() {
		
	}
	
	void runForUnaryOperator() {
		UnaryOperator<Integer> uo = i -> (int)(Math.random() * i);
		IO.println(uo.apply(100));
		
		BinaryOperator<Double> bo = (a, b) -> a * b;
		IO.println(bo.apply(1.0, 2.0));
	}
	
	void runForSupplier() {
		Supplier<Double> giveRandom = () -> Math.abs(Math.random());
		IO.println(giveRandom.get());
	}
	
	void runForConsumer() {
		Consumer<String> nameConsume = input -> IO.println("Hello, " + input);
		nameConsume.accept("Consumer");
	}
	
	void runForFunction() {
		
		Function<String, Integer> getLength = str -> str.length();
		IO.println(getLength.apply("Lambda"));
		
		Function<String, Character> getChar = str -> str.charAt(0);
		IO.println(getChar.apply("Functional"));
		
	}
	
	void runForPredicate() {
		Predicate<Integer> isPositive = i -> i > 0;
		IO.println(isPositive.test(10));
		
		Predicate<String> pred = (String s) -> {
			return s.contains("ava");
		};
		IO.println(pred.test("Python"));
	}
	
	void runForConstMF() {
		Startable srt = Reference::new;
		IO.println(srt.start());
	}
	
	void runForArbitraryMF() {
		
		String[] names = {"Aung Ko", "Khant Min", "Kyaw Lin"};
		
		Arrays.sort(names, String::lastIndexOf);
		
	}
	
	void runForMF() {
		
		Calculable cal = Reference::executeStatic;
		IO.println(cal.calculate(2, 3));
		
		Greetable refGrt = new Reference()::hello;
		IO.println(refGrt.greet("David"));
		
		Greetable curGrt = this::hi;
		IO.println(curGrt.greet("Isabella"));
	}
	
	String hi(String name) {
		return "Hi " + name;
	}
	
	void runForEffectiveFinal() {
		
//		String text = "AIC Start...";
//		Startable obj = () -> IO.println(text);
//		obj.start();
	
	}
	
	void runForLambda() {
		
//		Startable aicStart = new Startable() {			
//			@Override
//			public void start() {
//				IO.println("AIC Start...");
//			}
//		};
//		
//		Startable lamStart = () -> IO.println("Lambda Start...");
//		
//		aicStart.start();
//		lamStart.start();
//		IO.println();
		
		Greetable aicGreet = new Greetable() {
			@Override
			public String greet(String who) {
				return "Hello " + who;
			}
		};
		
		Greetable lamGreet = a -> "Hi " + a;
			
		IO.println(aicGreet.greet("Alan"));
		IO.println(lamGreet.greet("Orion"));
		IO.println();
		
		Calculable aicCalc = new Calculable() {
			@Override
			public int calculate(int x, int y) {
				return x + y;
			}
		};
		
		Calculable lamCalc = (x, y) -> x * y;
		
		IO.println(aicCalc.calculate(4, 7));
		IO.println(lamCalc.calculate(2, 8));
		
	}

}
