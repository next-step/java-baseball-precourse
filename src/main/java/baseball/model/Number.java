package baseball.model;

public class Number {

	private final int index;
	private final int value;

	public Number(int index, int value) {
		this.index = index;
		this.value = value;
	}

	public boolean on(Number number) {
		return this.index == number.index;
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		return value;
	}
}
