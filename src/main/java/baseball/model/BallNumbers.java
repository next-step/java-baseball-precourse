package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BallNumbers {

	private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
	private final List<BallNumber> ballNumberList;

	public BallNumbers(List<BallNumber> ballNumberList) {
		this.ballNumberList = ballNumberList;
	}

	public static BallNumbers of(List<Integer> numbers) {
		List<BallNumber> ballNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			BallNumber ballNumber = new BallNumber(number);
			validateDuplicateBallNumber(ballNumbers, ballNumber);
			ballNumbers.add(ballNumber);
		}
		return new BallNumbers(ballNumbers);
	}

	private static void validateDuplicateBallNumber(List<BallNumber> ballNumbers, BallNumber ballNumber) {
		if (ballNumbers.contains(ballNumber)) {
			throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
		}
	}

	public List<BallNumber> getBallNumberList() {
		return this.ballNumberList;
	}

	public int getNumberSize() {
		return this.ballNumberList.size();
	}

	public int getNumber(int index) {
		return this.ballNumberList.get(index).getNumber();
	}

}
