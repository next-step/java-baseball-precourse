package baseball.utils;

public class PickNumber {
	public static final String SPACE = " ";
	public static final String STRIKE = "스트라이크";
	public static final String BALL = "볼";
	public static final String NOTING = "낫싱";

	/**
	 * 해당하는 자리의 숫자 조회
	 * @param pickNumber
	 * @param digit
	 * @return
	 */
	public static int getDigitNumber(int pickNumber, int digit) {
		return (int)(pickNumber / Math.pow(10, digit - 1)) % 10;
	}

	/**
	 * 원하는 자리수에 해당하는 숫자인지 확인
	 * @param pickNumber
	 * @param digit
	 * @return
	 */
	public static Boolean validateNumberOfDigit(int pickNumber, int digit) {
		// n 자리 숫자 :  10^n 보다는 작고, 10^(n-1) 보다는 크거나 같고
		// ex) 3 자리 숫자 : 99 보다는 크고, 1000 보다는 작고
		// 	-> 10^2 크거나 같고, 10^3 보다는 작고
		if (pickNumber >= Math.pow(10, digit) || pickNumber < Math.pow(10, digit - 1)) {
			return false;
		}

		return true;
	}

	/**
	 * 지정한 자리수의 숫자가 같은지 확인
	 * @param pickNumber
	 * @param startDigitIndex
	 * @param endDigitIndex
	 * @return
	 */
	public static Boolean validateDigitNumberDistinct(int pickNumber, int startDigitIndex, int endDigitIndex) {
		int startDigitNumber = getDigitNumber(pickNumber, startDigitIndex);
		int endDigitNumber = getDigitNumber(pickNumber, endDigitIndex);
		return startDigitNumber != endDigitNumber;
	}

	/**
	 * 랜덤의 숫자가 3자리 수이고 모두 다른 숫자인지 확인
	 * @param pickNumber
	 * @return
	 */
	public static Boolean validatePickNumber(int pickNumber) {
		// 3자리의 숫자가 맞는지 확인
		if (!validateNumberOfDigit(pickNumber, 3)) {
			return false;
		}

		// 각 자리의 숫자가 서로 다른 숫자가 맞는지 확인
		if (!validateDigitNumberDistinct(pickNumber, 3, 2)
				|| !validateDigitNumberDistinct(pickNumber, 3, 1)
				|| !validateDigitNumberDistinct(pickNumber, 2, 1)) {
			return false;
		}

		return true;
	}

	public static int getStrikeCount(int pickNumber, int playerNumber) {
		int count = 0;

		// 각 자리수의 숫자가 같은지 확인
		for (int index = 1; index < 4; index++) {
			if (PickNumber.getDigitNumber(pickNumber, index) == PickNumber.getDigitNumber(playerNumber, index)) {
				count++;
			}
		}

		return count;
	}

	public static Boolean checkBall(int pickNumber, int playerNumber, int pickDigit) {
		int pickDigitNumber = PickNumber.getDigitNumber(pickNumber, pickDigit);

		for (int index = 0; index < 3; index++) {
			int tempPlayerDigit = (index % 3) + 1;

			if (pickDigit == tempPlayerDigit) {
				continue;
			}

			if (pickDigitNumber == PickNumber.getDigitNumber(playerNumber, tempPlayerDigit)) {
				return true;
			}
		}

		return false;
	}

	public static int getBallCount(int pickNumber, int playerNumber) {
		int count = 0;

		for (int index = 1; index < 4; index++) {
			if (checkBall(pickNumber, playerNumber, index)) {
				count++;
			}
		}

		return count;
	}

	public static String comparingNumbers(int pickNumber, int playerNumber) {
		String resultValue = "";
		int strikeCount = getStrikeCount(pickNumber, playerNumber);
		int ballCount = getBallCount(pickNumber, playerNumber);

		if (strikeCount != 0) {
			resultValue += strikeCount + STRIKE + SPACE;
		}

		if (ballCount != 0) {
			resultValue += ballCount + BALL;
		}

		if (resultValue.equals("")) {
			resultValue = NOTING;
		}

		return resultValue.trim();
	}
}
