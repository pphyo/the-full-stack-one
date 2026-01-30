package tech.codoverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionService {
	
	private List<String> database = new ArrayList<>();
	
	public boolean save(String str) {
		return database.add(str);
	}
	
	public String update(String old, String newStr) {
		return database.set(database.indexOf(old), newStr);
	}
	
	public boolean delete(String obj) {
		return database.remove(obj);
	}
	
	public List<String> getAll() {
		return Collections.unmodifiableList(database);
	}

}
