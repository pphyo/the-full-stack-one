package tech.codoverse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenericApp {

	void main() {
		
		runForBoundedType();
		
	}
	
	void runForWildCard() {
		List<?> unbounedList = new ArrayList<>();
		unbounedList.add(null);
	}
	
	void runForGenericSubType() {
		List<String> list = new PayloadList<String, LocalDate>();
		IO.println(list);
	}
	
	void runForBoundedType() {
		BoundedBox<String> box = new BoundedBox<>("");
		box.inspect(100d);
		
//		List<Integer> intList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//		List<Double> doubledList = List.of(0.2, 1.0, 2.1, 3.0, 4.3, 5.0, 6.0, 7.0, 8.1);
		List<BigDecimal> biList = List.of(
				new BigDecimal("1.55"),
				new BigDecimal("7.27"),
				new BigDecimal("4.19"),
				new BigDecimal("5.30"),
				new BigDecimal("2.0"),
				new BigDecimal("9.94"),
				new BigDecimal("0.01")
				);
		var util = new Util();
		var result = util.sumAllEven(biList);
		IO.println(result);
	}
	
	@SuppressWarnings({"rawtypes"})
	void runForRawType() {
		
		Box rawBox = new Box();
		
		Box<Integer> genBox = new Box<>();
		genBox.setData(100);
		rawBox = genBox;
		
		IO.println(rawBox == genBox);
		IO.println(rawBox.getData());
		
		new Card("Const");
		
	}
	
	void runForGenericMethod() {
		Pair<String, Integer> p1 = new OrderPair<>("Apple", 1200);
		Pair<String, Integer> p2 = new OrderPair<>("Apple", 1200);
		Util.compare(p1, p2);
	}
	
	void runForMultipleTypeParam() {
		Pair<String, Number> p1 = new OrderPair<>("Apple", 1200);
		IO.println("P1 Key: " + p1.getKey());
		IO.println("P1 Value: " + p1.getValue());
		
		Pair<String, String> p2 = new OrderPair<>("CB", "Pe Pe");
		IO.println("P2 Key: " + p2.getKey());
		IO.println("P2 Value: " + p2.getValue());
	}
	
	void runForWithGeneric() {
		Box<Integer> intBox = new Box<Integer>();
		intBox.setData(100);
		IO.println(intBox.getData() * 2);
		
		Box<String> strBox = new Box<>();
		strBox.setData("Java");
		IO.println(strBox.getData().concat(" Generic"));
	}
	
	void runForWithoutGeneric() {
		DataForAll intDataObj = new DataForAll(100);
		intDataObj.setData("sdfkjlsd");
		int intData = (Integer)intDataObj.getData();
		IO.println(intData);
		
		DataForAll strDataObj = new DataForAll("Generic");
		String strData = (String)strDataObj.getData();
		IO.println(strData);
	}

}
