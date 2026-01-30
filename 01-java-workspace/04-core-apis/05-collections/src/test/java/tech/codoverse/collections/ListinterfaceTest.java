package tech.codoverse.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ListinterfaceTest {
	
	static final List<Integer> list = List.of(5, 3, 4, 0, 6, 9, 7);
	
	@Test
	void test_for_linked_list() {
		
		List<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addAll(list);
		linkedList.add(0);
		linkedList.addFirst(0);
		
		IO.println(linkedList.lastIndexOf(0));
		
		IO.println(linkedList);
		
	}
	
	@Test
	@Disabled
	void test_for_array_list() {
		List<Integer> arrayList = new ArrayList<>(list);
		assertEquals(7, arrayList.size());
		
		assertTrue(arrayList.add(0));
		arrayList.add(0, 10);
		assertEquals(9, arrayList.size());
		assertEquals(10, arrayList.get(0));
		
		assertEquals(4, arrayList.set(3, 6));
		assertEquals(6, arrayList.get(3));
		
		assertEquals(5, arrayList.remove(1));
		assertEquals(8, arrayList.size());
		
		assertTrue(arrayList.remove(Integer.valueOf(9)));
		assertEquals(7, arrayList.size());
		
		IO.println(arrayList);
	}

}
