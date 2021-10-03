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
}
