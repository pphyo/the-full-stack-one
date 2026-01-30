package tech.codoverse.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class SetInterfaceTest {
	
	static final Set<Integer> set = Set.of(5, 4, 2, 1, 9, 0, 8);
	
	@Test
	void test_for_tree_set() {
		Set<Integer> treeSet = new TreeSet<>(set);
		
		IO.println(treeSet);
	}
	
	@Test
	void test_for_hash_set() {
		Set<Integer> hashSet = new HashSet<>();
		
		assertNotNull(hashSet);
		assertTrue(hashSet.isEmpty());
		
		hashSet.addAll(set);
		
		assertFalse(hashSet.isEmpty());
		assertEquals(7, hashSet.size());
		
		assertTrue(hashSet.contains(1));
		assertFalse(hashSet.contains(3));
		
		assertTrue(hashSet.containsAll(Set.of(4, 9, 0, 2)));
		assertFalse(hashSet.containsAll(Set.of(4, 3, 2, 0)));
		
		assertTrue(hashSet.add(3));
		assertEquals(8, hashSet.size());
		
		assertTrue(hashSet.contains(3));
		
		assertFalse(hashSet.add(0));
		assertEquals(8, hashSet.size());
		
		assertTrue(hashSet.remove(0));
		assertEquals(7, hashSet.size());
		
		assertFalse(hashSet.contains(0));
		
		assertFalse(hashSet.remove(7));
		assertEquals(7, hashSet.size());
		
		Set<Integer> other = new HashSet<>(Set.of(0, 1, 2, 4));
		
		assertTrue(hashSet.retainAll(other));
		
		IO.println(hashSet);
		
		hashSet.clear();
		
		assertTrue(hashSet.isEmpty());
		assertEquals(0, hashSet.size());
	}

}
