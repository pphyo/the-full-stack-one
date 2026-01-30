package tech.codoverse.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class RemoveWhileIterateTest {
	
	static List<String> list = new ArrayList<>(Arrays.asList(
			"Bob", "Calara", 
			"David", "Ellene",
			"Calvin", "William"));
	
	@Test
	void test_for_removeIf() {
//		Predicate<String> pred = new Predicate<String>() {
//			@Override
//			public boolean test(String str) {
//				return str.startsWith("Z");
//			}
//		};
		var result = list.removeIf(str -> str.startsWith("Z"));
		IO.println(result);
	}
	
	@Test
	@Disabled
	void test_for_remove_with_iterator() {
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			String ele = itr.next();
			if(ele.startsWith("C"))
				itr.remove();
		}
		IO.println(list);
		
		
	}

}
