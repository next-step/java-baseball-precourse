package baseball.utils;

public class PickNumber {
	/**
	 * 해당하는 자리의 숫자 조회
	 * @param pickNumber
	 * @param digit
	 * @return
	 */
	public static int getDigitNumber(int pickNumber, int digit) {
		return (int)(pickNumber / Math.pow(10, digit - 1)) % 10;
	}
}
