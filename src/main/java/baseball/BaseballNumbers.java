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
			count += countSameNumber(computerNumbers, index);
		}
		return count;
	}

	public int countSameNumberAndLocation(BaseballNumbers computer) {
		List<Integer> computerNumbers = computer.getBaseballNumbers();
		int count = 0;
		for (int index = 0; index < baseballNumbers.size(); index++) {
			count += countSameNumberAndLocation(computerNumbers, index);
		}
		return count;
	}

	private int countSameNumber(List<Integer> computerNumbers, int index) {
		int number = baseballNumbers.get(index);
		if (computerNumbers.contains(number)) {
			return 1;
		}
		return 0;
	}

	private int countSameNumberAndLocation(List<Integer> computerNumbers, int index) {
		int number = baseballNumbers.get(index);
		if (computerNumbers.get(index) == number) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseballNumbers other = (BaseballNumbers)o;
		int count = countSameNumberAndLocation(other);
		if(count == 3){
			return true;
		}
		return false;
	}
}
