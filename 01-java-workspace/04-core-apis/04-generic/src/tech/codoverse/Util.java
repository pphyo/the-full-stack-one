package tech.codoverse;

import java.util.List;

public class Util {
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) &&
				p1.getValue().equals(p2.getValue());
	}
	
	public double sumAllEven(List<? extends Number> list) {
		var result = 0.0;
		
		for(var item : list) {
			if(item.intValue() % 2 == 0) {
				result += item.doubleValue();
			}
		}
		
		return result;
	}

}
