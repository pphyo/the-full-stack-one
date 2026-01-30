package tech.codoverse.collections;

import org.junit.jupiter.api.Test;

import tech.codoverse.CollectionService;

public class CollectionServiceTest {
	
	@Test
	void test() {
		CollectionService service = new CollectionService();
		service.save("Java");
		service.save("Javascript");
		service.save("Python");
		service.save("Dart");
		
		var list = service.getAll();
		list.add("C");
		
		IO.println(service.getAll());
		
	}

}
