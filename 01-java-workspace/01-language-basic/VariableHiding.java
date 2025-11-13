class Item {

	static int id;
	String name = "Macbook M2 Pro";

	void setItemName(String name) {
		System.out.println("Name: " + name);
		System.out.println("This name: " + this.name);
	}

	void setItemId(int id) {
		Item.id = id;
	}

}

public class VariableHiding {
	
	public static void main(String[] args) {
		new VariableHiding().launch();
	}

	void launch() {
		var item = new Item();
		item.setItemName("iPhone 17");
		item.setItemId(10);

		System.out.println(item.name);
		System.out.println(Item.id);
	}

}