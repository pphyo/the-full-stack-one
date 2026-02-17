package com.codoverse;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamApisApp {
	
	void main() {
		// List.of(10, -2, 55, 1, 21, 17, 900, 36);
		String text = "10\n2\n55\n1\n21\n17\n900\n36";
		runForReduceAndIterate(text);
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
