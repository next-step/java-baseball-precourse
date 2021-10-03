package baseball.util;

/**
 * 숫자야구게임의 input이 되는 숫자로 된 String 을 검증하기 위한 Util 클래스이다.
 */
public class ValidationUtils {

	private static final int BASEBALL_INPUT_LENGTH = 3;

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
		if (inputChar < '1' || inputChar > '9') {
			throw new IllegalArgumentException("[ERROR] 1-9 까지의 문자만 입력가능합니다.");
		}
	}
}
