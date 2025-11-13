public class PassByValue {

	void main() {
		// int value = 10;
		// tryToChange(value);
		// IO.println("Value: " + value);

		var category = new Category("Mobile");
		IO.println("Orignal: " + category.getName());
		changeRef(category);
		IO.println("Orignal: " + category.getName());
	}

	void changeRef(Category category) {
		IO.println("Before change: " + category);
		category.setName("Smart TV");
		IO.println("After changed: " + category);
	}

	void tryToChange(int num) {
		IO.println("Before change: " + num);
		num = 20;
		IO.println("After changed: " + num);
	}

}


class Category {
	private String name;

	public Category(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}