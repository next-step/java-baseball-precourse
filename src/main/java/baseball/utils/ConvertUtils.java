package baseball.utils;

public class ConvertUtils {

	/**
	 * 숫자형태의 character ('0'-'9') 를 int (0-9) 로 변환하여 반환한다.
	 *
	 * @param input 숫자 형태의 character
	 * @return int 로 변환된 character
	 */
	public static int charToInt(char input) {
		return input - '0';
	}
}
