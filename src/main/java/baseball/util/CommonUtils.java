package baseball.util;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class CommonUtils {

	/**
	 * String 의 null 과 empty 체크 
	 * 
	 * @param str 입력값
	 * @return null,empty 일경우 true | else false
	 * */
	public static boolean isNullOrEmpty(String str) {
		if ( str == null || str.isEmpty() || str.trim().isEmpty() ) {
			return true;
		}

		return false;
	}

	/**
	 * String 의 not null 과 not empty 체크 
	 * 
	 * @param str 입력값
	 * @return not null , not empty 일경우 true | else false 
	 * */
	public static boolean isNotNullOrEmpty(String str) {
		if ( str != null && !str.isEmpty() || !str.trim().isEmpty() ) {
			return true;
		}

		return false;
	}

	/**
	 * String이 숫자만 이루어진경우를 체크
	 * 
	 * @param str 입력값
	 * @return 숫자일경우 true | else false  
	 * */
	public static boolean isNumber(String str) {
		if ( isNullOrEmpty(str) ) {
			return false ; 
		}
		
		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}
}
