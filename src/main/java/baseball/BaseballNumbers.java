package baseball;

import java.util.List;

public class BaseballNumbers {
	private List<Integer> baseballNumbers;

	public BaseballNumbers(List<Integer> baseballNumbers) {
		this.baseballNumbers = baseballNumbers;
	}

	public List<Integer> getBaseballNumbers() {
		return baseballNumbers;
	}

	public int countSameNumber(BaseballNumbers computer) {
		List<Integer> computerNumbers = computer.getBaseballNumbers();
		int count = 0;
		for (int index = 0; index < baseballNumbers.size(); index++) {
			int number = baseballNumbers.get(index);
			if (computerNumbers.contains(number)) {
				count++;
			}
		}
		return count;
	}

	public int countSameNumberAndLocation(BaseballNumbers computer) {
		List<Integer> computerNumbers = computer.getBaseballNumbers();
		int count = 0;
		for (int index = 0; index < baseballNumbers.size(); index++) {
			int number = baseballNumbers.get(index);
			if (computerNumbers.get(index) == number) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseballNumbers other = (BaseballNumbers)o;
		List<Integer> otherBaseballNumbers = other.getBaseballNumbers();

		for (int index = 0; index < this.baseballNumbers.size(); index++) {
			int number = this.baseballNumbers.get(index);
			if (otherBaseballNumbers.get(index) != number) {
				return false;
			}
		}
		return true;
	}
}
