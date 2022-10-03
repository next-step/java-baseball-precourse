package baseball.util;

import static baseball.message.ErrorMessage.INPUT_BALLS_ERROR;

import java.util.ArrayList;
import java.util.List;

public class BallNumberUtils {

	public static List<Integer> toBallNumbers(String str, int minBallNo, int maxBallNo, int ballCount) {
		if (str.length() != 3) {
			throw new IllegalArgumentException(INPUT_BALLS_ERROR.toString());
		}

		List<Integer> numbers = new ArrayList<>();
		String[] strArr = str.split("");

		for (String num : strArr) {
			int number = toBallNumber(num, minBallNo, maxBallNo);
			if (!numbers.contains(number)) {
				numbers.add(number);
			}
		}

		if (numbers.size() != ballCount) {
			throw new IllegalArgumentException(INPUT_BALLS_ERROR.toString());
		}

		return numbers;
	}

	public static int toBallNumber(String str, int minBallNo, int maxBallNo) {
		if (str == null) {
			throw new IllegalArgumentException(INPUT_BALLS_ERROR.toString());
		}

		try {
			int ballNo = Integer.parseInt(str);
			if (ballNo < minBallNo || ballNo > maxBallNo) {
				throw new IllegalArgumentException(INPUT_BALLS_ERROR.toString());
			}

			return ballNo;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INPUT_BALLS_ERROR.toString());
		}
	}
}
