package tech.codoverse;

public class GenericApp {
	
	void main() {
		
		
		
	}
	
	void runForGenericMethod() {
		Pair<String, Integer> p1 = new OrderPair<>("Apple", 1200);
		Pair<String, Integer> p2 = new OrderPair<>("Apple", 1200);
		Util.compare(p1, p2);
	}
	
	void runForMultipleTypeParam() {
		Pair<String, Integer> p1 = new OrderPair<>("Apple", 1200);
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
