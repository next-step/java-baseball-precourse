package baseball.util;

import java.util.ArrayList;
import java.util.List;

import baseball.vo.BallNumberVo;
import nextstep.utils.Randoms;

public class BallNumberUtil {
	private final static int SELECTED_NUMBER_SISE = 3;
	private final static int SELECTED_NUMBER_MIN = 1;
	private final static int SELECTED_NUMBER_MAX = 9;

	public static BallNumberVo createSelectedNumberList() {
		BallNumberVo selectedNumber = new BallNumberVo();
		do {
			selectedNumber.setNumbers(createNumbers());
		} while (!checkSelectedNumber(selectedNumber));

		return selectedNumber;
	}

	public static Boolean checkSelectedNumber(BallNumberVo selectedNumber) {
		List<Integer> numbers = selectedNumber.getNumbers();
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
		return true;
	}

	public static BallNumberVo stringToBallNumber(String str) {
		BallNumberVo ballNumber = new BallNumberVo();
		List<Integer> numbers = stringToNumbers(str);
		ballNumber.setNumbers(numbers);
		return ballNumber;
	}

	private static List<Integer> stringToNumbers(String str) {
		List<Integer> numbers = new ArrayList<Integer>();
		String[] splitedStrList = str.split(",");
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
