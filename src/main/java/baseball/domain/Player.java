package baseball.domain;

import java.util.List;
import java.util.Objects;

import baseball.utils.IntegerUtils;

public class Player {
	private final Numbers values;

	public Player(Numbers values) {
		this.values = values;
	}

	public static Player create(String intString) {
		List<Integer> values = IntegerUtils.convertStringToIntegerList(intString);
		return new Player(new Numbers(values));
	}

	public boolean isContainsNumber(Number number) {
		return values.isContains(number);
	}

	public int getNumberIndex(Number number) {
		return values.getNumberIndex(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Player player = (Player)o;
		return Objects.equals(values, player.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
