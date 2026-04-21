package com.codoverse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Gatherer;
import java.util.stream.Gatherer.Integrator;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class StreamApisApp {
	
	void main() {
		try {
			// List.of(10, -2, 55, 1, 21, 17, 900, 36);
			//String text = "10\n2\n55\n1\n21\n17\n900\n36";
			// List.of(0, 2, 4, 9, 7, 6, 8, 1, 3, 5)
			// runForMapping(Path.of("data.csv"));
			
//			List<List<Integer>> list = List.of(
//						List.of(0, 1, 2),
//						List.of(9, 8, 7),
//						List.of(5, 6),
//						List.of(4, 3)
//					);
//			runForFlatMap(list);
			
//			runForGatherer(List.of(0, 8, 9, 1, 2, 4, 6, 7, 5, 3));
			runForCustomGathererWithGather(List.of("Apple:50", "Banana:Invalid", "Orange:150", "Grape:-10", "Mango:80", "BadData"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	void runForCustomGathererWithGather(List<String> rawData) {
		
		@SuppressWarnings("unused")
		Integrator<Void, String, Integer> integrator = (state, element, downstream) -> {
			
			String[] parts = element.split(":");
			
			if(parts.length == 2) {
				try {
					int price = Integer.parseInt(parts[1]);
					
					if(price > 0 && price <= 100) {
						downstream.push(price);
					}
				} catch (NumberFormatException e) {
				}
			}
			return true;
		};
		
		
		List<Integer> validPrices = rawData
					.stream()
					.gather(Gatherer.of(integrator))
					.toList();
		IO.println(validPrices);
		
	}
	
	void runForCustomGathererWithSimple(List<String> rawData) {
		List<Integer> validPrices = rawData.stream()
					.filter(rd -> rd.contains(":"))
					.map(rd -> {
						try {
							return Integer.parseInt(rd.split(":")[1]);
						} catch (Exception e) {
							return -1;
						}
					})
					.filter(price -> price > 0 && price <= 100)
					.toList();
		IO.println(validPrices);
		
	}
	
	void runForGatherer(List<Integer> list) {
		
		var windowFixedResult = list.stream().gather(Gatherers.windowFixed(3)).toList();
		IO.println("Window Fixed: " + windowFixedResult);
		
		var windowSlidingResult = list.stream().gather(Gatherers.windowSliding(2)).toList();
		IO.println("Window Sliding: " + windowSlidingResult);
		
		Supplier<Integer> sup = () -> 1;
		BiFunction<Integer, Integer, Integer> biFunc = (a, b) -> a * b;
		
		var foldResult = list.stream().gather(Gatherers.fold(sup, biFunc)).toList();
		IO.println("Fold: " + foldResult);
		
		var scanResult = list.stream().gather(Gatherers.scan(sup, biFunc)).toList();
		IO.println("Scan: " + scanResult);
		
	}
	
	void runForCollect() {
		List<String> list = List.of("Java", "Python", "Go", "Rust", "C", "C++", "C#", "Javascript", "Dart", "Swift", "Objective C", "Ruby", "Perl");
		
		
		var joinReuslt = list.stream().collect(Collectors.joining(", ", "Computer Lanugage: ", ", Kotlin"));
		
		IO.println(joinReuslt);
		
		IO.println();
		
		Map<Boolean, List<String>> groupResult = list.stream().collect(Collectors.groupingBy(s -> s.contains("C")));
		IO.println(groupResult.get(false));
		IO.println();
		
		Map<Boolean, List<String>> partitionResult = list.stream().collect(Collectors.partitioningBy(s -> s.startsWith("C")));
		IO.println(partitionResult);
		IO.println();
		
		var summarizedResult = Stream.of(20, 11, 32, 7, 54, 95, 40, 18)
									.collect(Collectors.summarizingDouble(i -> Double.valueOf(i)));
		
		IO.println(summarizedResult);
		
	}
	
	void runForMapMulti(List<String> words) {
		
		List<String> result = words.stream()
							.mapMulti((String word, Consumer<String> consumer) -> {
								consumer.accept(word.toUpperCase());
								consumer.accept(word.toLowerCase());
							})
							.toList();
		IO.println(result);
		
	}
	
	void runForFlatMap(List<List<Integer>> list) {
		
		list.stream()
			.flatMap(l -> l.stream().map(i -> i))
			.sorted((a, b) -> b - a)
			.forEach(IO::println);
		
	}
	
	void runForMapping(Path path) throws IOException {
		// ["Ei Thet Mg", "6", "Female"]
		Files.lines(path)
				.map(Student::new)
				.sorted()
				.filter(s -> s.age() > 7)
				.forEach(IO::println);
	}
	
	void runForTWAndDW(List<Integer> list) {
		Predicate<Integer> even = i -> i % 2 == 0;
		list.stream().takeWhile(even).forEach(this::print);
	}
	
	void runForFiltering(List<Integer> collection) {
		
		Predicate<Integer> pred = this::isPrime;
		
		collection.stream().filter(pred).forEach(this::print);
		IO.println();
		
		collection.stream().distinct().forEach(this::print);
		IO.println();
		
		collection.stream().limit(3).forEach(this::print);
		IO.println();
		
		collection.stream().skip(3).forEach(this::print);
		IO.println();
		
		collection.stream()
				.distinct()
				.limit(5)
				.skip(2)
				.forEach(this::print);
		
	}
	
	private void print(Integer i) {
		IO.print(i + ", ");
	}
	
	private boolean isPrime(int number) {
		if(number < 2) {
			return false;
		}
		
		for(int i = 2; i < number; i++) {
			if(number % 2 == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	void runForRestOfTerminalOp(Path path) throws IOException {
		long count = Files.lines(path).count();
		IO.println(count);
	}
	
	void runForReduceAndIterate(String text) {
		var result = text.lines().parallel().reduce("", (a, b) -> a + "-" + b, (a, b) -> a + (a.isBlank() ? "" : ", ") +  b);
		IO.println(result);
	}
	
	void runForFindingAndMatching(List<Integer> list) {
		var findAnySeq = list.stream().findAny();
		var findAnyPar = list.parallelStream().findAny();
		
		IO.println("Sequential Find Any: " + findAnySeq);
		IO.println("Parallel Find Any: " + findAnyPar);
		
		IO.println();
		
		var findFirstSeq = list.stream().findFirst();
		var findFirstPar = list.parallelStream().findFirst();
		
		IO.println("Sequential Find First: " + findFirstSeq);
		IO.println("Parallel Find First: " + findFirstPar);
		
		IO.println();
		
		Predicate<Integer> even = i -> i % 2 == 0;
		Predicate<Integer> odd = i -> i % 2 != 0;
		
		var any = list.stream().anyMatch(i -> i == 17);
		var all = list.stream().allMatch(even.or(odd));
		var none = list.stream().noneMatch(i -> i > 1000);
		
		IO.println(any);
		IO.println(all);
		IO.println(none);
	}
	
	void run(Integer[] array) {
		
		try {
			var stream = Arrays.stream(array);
			
			var inter1 = stream.filter(i -> i > 3);
			
			var inter2 = inter1.filter(i -> i < 8);
			
			inter2.forEach(IO::println);
			
			stream.filter(i -> i == 0);
		} catch(IllegalStateException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	int sumOfAll(int[] array) {
		return Arrays.stream(array).sum();
	}

}
