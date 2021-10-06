package baseball.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.exception.InvalidBallNumberException;
import baseball.vo.BallNumberVo;
import nextstep.utils.Randoms;

public class BallNumberUtil {
	private final static int SELECTED_NUMBER_SISE = 3;
	private final static int SELECTED_NUMBER_MIN = 1;
	private final static int SELECTED_NUMBER_MAX = 9;

	public static BallNumberVo createBallNumber() {
		BallNumberVo ballNumber = new BallNumberVo();
		do {
			ballNumber.setNumbers(createNumbers());
		} while (!checkBallNumber(ballNumber));

		return ballNumber;
	}

	public static Boolean checkBallNumber(BallNumberVo ballNumber) {
		List<Integer> numbers = ballNumber.getNumbers();
		if (numbers == null) {
			return false;
		}
		if (numbers.size() != SELECTED_NUMBER_SISE) {
			return false;
		}

		for (Integer number : numbers) {
			if (number < SELECTED_NUMBER_MIN) {
				return false;
			}
			if (number > SELECTED_NUMBER_MAX) {
				return false;
			}
		}

		Set<Integer> set = new HashSet<Integer>(numbers);
		if (set.size() < numbers.size()) {
			return false;
		}

		return true;
	}

	public static BallNumberVo stringToBallNumber(String str) throws InvalidBallNumberException {
		BallNumberVo ballNumber = new BallNumberVo();
		List<Integer> numbers = stringToNumbers(str);
		ballNumber.setNumbers(numbers);
		if (!checkBallNumber(ballNumber)) {
			throw new InvalidBallNumberException();
		}
		return ballNumber;
	}

	private static List<Integer> stringToNumbers(String str) {
		List<Integer> numbers = new ArrayList<Integer>();
		String[] splitedStrList = str.split("");
		for (String splitedStr : splitedStrList) {
			numbers.add(Integer.parseInt(splitedStr));
		}
		return numbers;
	}

	private static List<Integer> createNumbers() {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < SELECTED_NUMBER_SISE; i++) {
			numbers.add(Randoms.pickNumberInRange(1, 9));
		}
		return numbers;
	}
}
