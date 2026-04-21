package com.codoverse;

public record Student(String name, int age, Gender gender) implements Comparable<Student> {
	
	public Student(String line) {
		String[] array = line.split(",");
		this(array[0].strip(), Integer.parseInt(array[1].strip()), Gender.valueOf(array[2].strip()));
	}
	
	public enum Gender {
		Male, Female
	}
	
	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}

}
