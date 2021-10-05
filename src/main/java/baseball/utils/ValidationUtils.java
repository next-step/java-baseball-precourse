package baseball.utils;

/**
 * 숫자야구게임의 input이 되는 숫자로 된 String 을 검증하기 위한 Util 클래스이다.
 */
public class ValidationUtils {

	private static final int BASEBALL_INPUT_LENGTH = 3;
	private static final int MAX_BASEBALL_NUMBER = 9;
	private static final int MIN_BASEBALL_NUMBER = 1;

	public static void validateInput(String input) {
		isValidLength(input);
		containsBetweenOneToNine(input);
		hasNoDuplicateNumber(input);
	}

	/**
	 * input 의 길이가 3인지 확인한 뒤 올바르지 않은 경우 예외를 던진다.
	 *
	 * @param input 검증 대상이 되는 문자열
	 */
	public static void isValidLength(String input) {
		if (input.length() != BASEBALL_INPUT_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 길이가 3인 문자열만 입력가능합니다.");
		}
	}

	/**
	 * input 이 1-9 의 숫자들만을 포함하는 String 인지 판별한다.
	 *
	 * @param input 1-9 사이의 숫자들만 포함하는지 검증할 문자열
	 */
	public static void containsBetweenOneToNine(String input) {
		for (int i = 0; i < input.length(); i++) {
			isBetweenOneToNine(input.charAt(i));
		}
	}

	/**
	 * 1보다 작은 문자이거나, 9보다 큰 문자의 경우에 대해서 예외를 던진다.
	 *
	 * @param inputChar 1-9 사이의 숫자인지 검증할 character
	 */
	private static void isBetweenOneToNine(char inputChar) {
		final int inputInt = ConvertUtils.charToInt(inputChar);
		if (inputInt < MIN_BASEBALL_NUMBER || inputInt > MAX_BASEBALL_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 1-9 까지의 문자만 입력가능합니다.");
		}
	}

	/**
	 * 중복된 숫자가 있는지 판별한다.
	 *
	 * @param input 1-9 사이의 숫자로 된 문자열
	 */
	public static void hasNoDuplicateNumber(String input) {
		int[] array = new int[10];

		for (int i = 0; i < input.length(); i++) {
			final int count = ++array[ConvertUtils.charToInt(input.charAt(i))];
			isDuplicate(count);
		}
	}

	/**
	 * hasNoDuplicateNumber 에서 배열의 원소값에 따라 중복을 판단한다.
	 *
	 * @param count 1(중복아님) 혹은 2(중복)
	 */
	private static void isDuplicate(int count) {
		if (count > 1) {
			throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어있는 문자열입니다.");
		}
	}

}
