package baseball.model;

import java.util.HashSet;
import java.util.List;

import baseball.exception.DuplicatedNumberException;
import baseball.exception.InvalidFiguresNumberException;

public class OpponentBaseballNumber {

	private List<Integer> baseballNumbers;

	public OpponentBaseballNumber(List<Integer> baseballNumbers) {
		validateBaseballNumberSize(baseballNumbers);
		validateBaseballNumberDuplicated(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}

	public List<Integer> getBaseballNumbers() {
		return baseballNumbers;
	}

	public void createOpponentBaseballNumber(List<Integer> baseballNumbers) {
		validateBaseballNumberSize(baseballNumbers);
		validateBaseballNumberDuplicated(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}

	private void validateBaseballNumberSize(List<Integer> baseballNumbers) {
		if (baseballNumbers.size() != ConstValue.BASEBALL_SIZE)
			throw new InvalidFiguresNumberException();
	}

	private void validateBaseballNumberDuplicated(List<Integer> baseballNumbers) {
		HashSet<Integer> validateNumberHashSet = new HashSet<>(baseballNumbers);

		if (baseballNumbers.size() != validateNumberHashSet.size())
			throw new DuplicatedNumberException();
	}

}
