package tech.codoverse;

public class StringApiApp {
	
	void main() {
		runForTextBlock();
	}
	
	void runForTextBlock() {
		String json = "{\n\t\"name\": \"Mg Mg\",\n\t\"age\": 20,\n\t\"gender\": \"Male\"\n}";
		String jsonTb = """
				{
					"name": "Mg Mg",
					"age": 20,
					"gender": "Male"
				}""";
		IO.println(jsonTb);
		IO.println(json);
	}
	
	void runForSb() {
		StringBuilder sb = new StringBuilder();
		IO.println(sb.capacity());
		sb.append("Java")
			.append("Python")
			.append("Javascript11111111111111111");
		IO.println(sb.capacity());
		IO.println(sb.toString());
		
	}
	
	void runForCompileVsRuntimeConstant() {
		
		var first = "rat" + 1;
		var second = "r" + "a" + "t" + "1";
		
		var third = "r" + "a" + "t" + new String("1");
		
		var fourth = "rat";
		fourth += "1";
		
		IO.println(first == second);
		IO.println(first == third.intern());
		IO.println(first == fourth);
		
		var boolVal1 = "true";
		var boolVal2 = String.valueOf(true);
		
		IO.println(boolVal1 == boolVal2);
		
	}
	
	void runForCheckingEquality() {
		
		Player p1 = new Player("Player", "20303", "LF");
		Player p2 = new Player("Player", "20304", "LF");
		
		IO.println("p1 address: " + p1);
		IO.println("p2 address: " + p2);
		IO.println("p1 == p2: " + (p1 == p2));
		IO.println("p1.equals(p2): " + (p1.equals(p2)));
		
	}
	
	void runForCreatingString() {
		
		String str1 = "Java"; // 2301506 for ==, Java for .equals
		
		String str2 = "Java"; // 2301506
		
		String str3 = new String("Java");
		
		IO.println("str1 == str2: " + (str1 == str2));
		IO.println("str2 == str3: " + (str2 == str3));
		IO.println("str2.equals(str3): " + str2.equals(str3));
		
	}

}
