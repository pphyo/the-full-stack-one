package tech.codoverse.domain;

import java.util.List;
import java.util.UUID;

public class Hero {

	private String id;
	private String name;
	private Role role;
	private int skill;
	private String type;

	public Hero(String name, Role role, int skill, String type) {
		this.id = UUID.randomUUID().toString().substring(0, 12).replace("-", "");
		this.name = name;
		this.role = role;
		this.skill = skill;
		this.type = type;
	}
	
	public static List<Hero> init() {
		return List.of(
			new Hero("Miya", Role.Marksman, 3, "Finisher/Damage"),
			new Hero("Alucard", Role.Assasin, 3, "Chase/Damage"),
			new Hero("Akai", Role.Tank, 3, "Guard/Crowd Control"),
			new Hero("Balmond", Role.Fighter, 3, "Damage/Regen"),
			new Hero("Pharsa", Role.Mage, 4, "Burst/Poke"),
			new Hero("Faramis", Role.Support, 3, "Guard/Charge")
		);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public int getSkill() {
		return skill;
	}

	public String getType() {
		return type;
	}

	public enum Role {
		Tank, Fighter, Assasin, Mage, Marksman, Support
	}

}
