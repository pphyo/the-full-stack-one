package tech.codoverse.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import tech.codoverse.Named;

public class SpecialFeatureInCollectionTest {
	
	@Test
	void test_for_sorting() {
		List<Named> list = new ArrayList<>();
		
		Collections.addAll(list, 
					new Named(4, "Zaw", "Myint"),
					new Named(7, "Toe", "Aung"),
					new Named(3, "Sai", "Wai"),
					new Named(6, "Nilar", "Win"),
					new Named(1, "Ba", "Thaw")
				);
		
//		Comparator<Named> fristNameAsc = new Comparator<Named>() {
//			@Override
//			public int compare(Named o1, Named o2) {
//				return o1.first().compareTo(o2.first());
//			}
//		};
		
		Comparator<Named> fristNameDesc = new Comparator<Named>() {
			@Override
			public int compare(Named o1, Named o2) {
				return o2.first().compareTo(o1.first());
			}
		};
		
		Collections.sort(list, fristNameDesc);
		
		IO.println(list);
	}

}
