package tech.codoverse;

import java.util.Objects;

public class Player {

	private String name;
	private String id;
	private String role;

	public Player(String name, String id, String role) {
		super();
		this.name = name;
		this.id = id;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && Objects.equals(role, other.role);
	}

	

}
