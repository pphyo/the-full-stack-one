package tech.codoverse;

public record Named(
		int id,
		String first,
		String last) implements Comparable<Named> {

	@Override
	public int compareTo(Named o) {
		return id - o.id;
	}
	
	@Override
	public final String toString() {
		return "Named[id=%d, first=%s, last=%s]%n".formatted(id, first, last);
	}
}
