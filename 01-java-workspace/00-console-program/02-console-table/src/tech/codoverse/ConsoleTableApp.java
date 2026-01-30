package tech.codoverse;

import java.util.List;

import tech.codoverse.domain.Hero;
import tech.codoverse.domain.Student;
import tech.codoverse.table.GenericTableView;
import tech.codoverse.table.annotation.AnnotationTableView;

public class ConsoleTableApp {
	
	void main() {
		runForStudentWithAnno();
	}
	
	void runForStudentWithAnno() {
		List<Student> list = Student.init();
		AnnotationTableView<Student> table = new AnnotationTableView<>(list);
		table.print();
	}
	
	void runForHero() {
		List<Hero> list = Hero.init();
		GenericTableView<Hero> table = new GenericTableView<Hero>()
							.addColumn("ID", h -> String.valueOf(h.getId()))
							.addColumn("Name", h -> h.getName())
							.addColumn("Role", h -> h.getRole().toString())
							.addColumn("Skill", h -> String.valueOf(h.getSkill()))
							.addColumn("Type", h -> h.getType())
							.setData(list);
		table.printTable();
	}
	
	void runForStudent() {
		List<Student> list = Student.init();
		GenericTableView<Student> table = new GenericTableView<Student>()
							.addColumn("ID", s -> String.valueOf(s.getId()))
							.addColumn("Name", s -> s.getName())
							.addColumn("Gender", s -> s.getGender().toString())
							.addColumn("Dob", s -> s.getDob().toString())
							.addColumn("Address", s -> s.getAddress())
							.setData(list);
		table.printTable();
	}

}
