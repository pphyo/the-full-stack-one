public class FinalVariable {

	// can beinitialized in instance block and constructor
	final int instanceFinal;

	final static public int staticFinal;

	static {
		staticFinal = 200;
	}

	public FinalVariable() {
		instanceFinal = 10;
	}

	void main(final String[] args) {

		// args = new String[3]; // final parameter args
		args[0] = "React";
		args[1] = "Angular";
		args[2] = "Vue";

		System.out.println(java.util.Arrays.toString(args));

		final int value;

		value = 10;

		System.out.println(value);
		System.out.println("Instance Final: " + instanceFinal);
		System.out.println("Static Final: " + staticFinal);

		final Category category = new Category();
		category.name = "Shirt"; // this is allowed

		// category = new Category();

		var liquor = new Category();
		liquor.name = "Liquor";

		// category = liquor;

	}

}

class Category {
	String name;
}