package baseball.domain;

import java.util.Objects;

import baseball.generator.NumbersGenerator;

public class Computer {
	private final Numbers values;

	public Computer(Numbers values) {
		this.values = values;
	}

	public static Computer create(NumbersGenerator generator) {
		return new Computer(generator.createNumbers());
	}

	public Hint getHintFromPlayerNumbers(Player player) {
		Hint hint = Hint.create();

		for (int i = 0; i < Numbers.SIZE; i++) {
			Number number = values.get(i);
			int digit = i + 1;

			boolean existsNumber = player.isContainsNumber(number);
			boolean sameDigit = digit == player.getNumberDigit(number);
			hint = hint.hit(StrikeZone.of(existsNumber, sameDigit));
		}
		return hint;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Computer computer = (Computer)o;
		return Objects.equals(values, computer.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
