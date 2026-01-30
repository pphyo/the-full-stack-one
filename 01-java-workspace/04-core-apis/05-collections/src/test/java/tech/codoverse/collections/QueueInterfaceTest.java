package tech.codoverse.collections;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class QueueInterfaceTest {
	
	@Test
	void test_for_linked_list() {
		Queue<String> queue = new LinkedList<>();
		queue.addAll(List.of("b", "z", "s", "w", "i", "k", "d"));
		
		IO.println(queue);
		
		queue.clear();
		
		assertNull(queue.peek());
		
		assertThrows(NoSuchElementException.class, () -> queue.element());
	}
	
	@Test
	void test_for_priority_queue() {
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.offer(5);
		queue.offer(0);
		queue.offer(3);
		queue.offer(4);
		queue.offer(2);
		queue.offer(6);
		queue.offer(9);
		queue.offer(7);
		
		IO.println(queue);

	}

}
