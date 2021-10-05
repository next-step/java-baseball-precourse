package baseball;

import static baseball.constants.CommonConstant.*;
import static baseball.constants.MessageConstant.*;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력된 값의 유효성을 검증하는 클래스
 * @author Lee JeongHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Validator {

	private final String inGamePattern = "^([0-9])([0-9])([0-9])$";
	private final String newGamePattern = "^([1-2])$";

	/**
	 * 입력된 인풋안에 중복되는 값 여부 확인
	 *
	 * @param input 타이핑되어 입력된 값
	 * @return 중복 여부
	 */
	private boolean isDuplicated(String input) {
		Set<Character> set = new HashSet<>();
		for (char c : input.toCharArray()) {
			set.add(c);
		}
		return set.size() != input.length();
	}

	/**
	 * 입력된 인풋의 널 체크 및 입력 길이 확인
	 *
	 * @param input 타이핑되어 입력된 값
	 * @return 길이 매칭 여부
	 */
	private boolean isLengthCheck(String input, int size) {
		if (input == null) {
			return false;
		}
		return input.length() == size;
	}

	/**
	 * 입력된 인풋의 정규식 확인
	 *
	 * @param input 타이핑되어 입력된 값
	 * @return 정규식 매칭 여부
	 */
	private boolean isMatchPattern(String input, String pattern) {
		return Pattern.matches(pattern, input);
	}

	/**
	 * 게임 안에서 입력되는 값의 유효성 확인
	 *
	 * @param input 타이핑되어 입력된 값
	 */
	public void validInputInGame(String input) {
		if (!isLengthCheck(input, INPUT_MAX_COUNT)) {
			throw new InputMismatchException(ERROR_INVALID);
		}
		if (!isMatchPattern(input, inGamePattern)) {
			throw new InputMismatchException(ERROR_INVALID);
		}
		if (isDuplicated(input)) {
			throw new InputMismatchException(ERROR_DUPLICATED);
		}
	}

	/**
	 * 새 게임 진행여부시 입력되는 값의 유효성 확인
	 *
	 * @param input 타이핑되어 입력된 값
	 */
	public void validInputNewGame(String input) {
		if (!isLengthCheck(input, 1)) {
			throw new InputMismatchException(ERROR_INVALID);
		}
		if (!isMatchPattern(input, newGamePattern)) {
			throw new InputMismatchException(ERROR_ONE_OR_TOW);
		}
	}
}
