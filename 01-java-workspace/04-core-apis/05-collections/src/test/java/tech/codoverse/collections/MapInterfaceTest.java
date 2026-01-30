package tech.codoverse.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class MapInterfaceTest {
	
	@Test
	void test() {
		Map<String, String> map = new HashMap<>();
		assertNull(map.put("Korea", "Souel"));
		assertNull(map.put("Thailand", "Bangkok"));
		assertNull(map.put("Phillipine", "Manila"));
		assertNull(map.put("Singapore", "Singapore"));
		assertNull(map.put("Myanmar", "Yangon"));
		
		assertEquals("Yangon", map.put("Myanmar", "Naypyidaw"));
		
		IO.println("Keys: " + map.keySet());
		IO.println("Values: " + map.values());
		
		Set<Map.Entry<String, String>> entries = map.entrySet();
		
		for(Map.Entry<String, String> entry : entries) {
			IO.println("%s : %s".formatted(entry.getKey(), entry.getValue()));
		}
	}

}
