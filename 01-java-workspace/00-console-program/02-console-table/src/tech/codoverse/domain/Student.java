package tech.codoverse.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import tech.codoverse.table.annotation.Column;
import tech.codoverse.table.annotation.Table;

@Table(name = "Student Table")
public class Student {

	@Column(order = 1)
	private String id;
	@Column(order = 2)
	private String name;
	@Column(order = 4)
	private Gender gender;
	@Column(name = "Date of Birth", order = 3)
	private LocalDate dob;
	@Column(name = "Location", order = 5)
	private String address;

	public Student(String name, Gender gender, LocalDate dob, String address) {
		this.id = UUID.randomUUID().toString().substring(0, 12).replace("-", "");
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
	}
	
	public static List<Student> init() {
		return List.of(
			new Student("Kyaw Zayya", Gender.Male, LocalDate.of(2003, 10, 20), "Yangon"),
			new Student("Nan Khin Thandar Kyaw", Gender.Female, LocalDate.of(2008, 1, 15), "Myeik Hti Lar"),
			new Student("Min Khant Kyaw", Gender.Male, LocalDate.of(2004, 12, 30), "Mandalay")
		);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public enum Gender {
		Male, Female
	}

}
