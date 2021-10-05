package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import baseball.util.Checker;
import nextstep.utils.Console;

public class User {
	private static final String ENTER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String INPUT_REGEX = "[1-9]*";
	private static final String VALIDATE_ONE_TO_NINE_MESSAGE = "1 ~ 9 까지의 숫자만 입력해주세요.";
	private static final String VALIDATE_THREE_NUMBER_MESSAGE = "세 자리를 입력해주세요.";
	private static final String VALIDATE_DUPLICATE_NUMBER_MESSAGE = "입력값 중 중복된 값이 있습니다. 서로 다른 숫자를 입력해주세요.";
	private static final String VALIDATE_RESTART_NUMBER_MESSAGE = "잘못된 값을 입력하셨습니다. 다시 시작하시려면 1, 게임을 종료하시려면 2를 입력해주세요.";

	private User() {
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/02 11:06 오후
	 * @Description : 정상 입력 - 숫자 입력
	 * @return {@link Console#readLine()}
	 * @throws NoSuchElementException 입력값이 없을 때
	 * @throws IllegalStateException 스캐너가 닫혔을 때
	 *
	 **/
	public static String getNumberInput() throws NoSuchElementException, IllegalStateException {
		System.out.print(ENTER_NUMBERS_MESSAGE);

		String input = Console.readLine();

		if (
			!isOneToNine(input)
				|| !isThreeNumber(input)
				|| !isDuplicateNumber(input)
		)
			return getNumberInput();

		return input;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/05 10:03 오후
	 * @Description : 정상 입력 - 다시 시작(1) or 완전 종료(2) 여부 입력
	 * @return {@link Console#readLine()}
	 * @throws NoSuchElementException 입력값이 없을 때
	 * @throws IllegalStateException 스캐너가 닫혔을 때
	 *
	 **/
	public static String getRestartInput() throws NoSuchElementException, IllegalStateException {
		String input = Console.readLine();

		if (!isRestartNumber(input)) return getRestartInput();

		return input;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/06 12:45 오전
	 * @Description : 사용자가 1 ~ 9 의 숫자를 입력했는지 검증
	 *
	 **/
	private static boolean isOneToNine(String input) {
		if (!input.matches(INPUT_REGEX)) {
			System.out.println(VALIDATE_ONE_TO_NINE_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/06 12:46 오전
	 * @Description : 사용자가 세 개의 숫자를 입력했는지 검증
	 *
	 **/
	private static boolean isThreeNumber(String input) {
		if (input.length() != Checker.INPUT_MIN_SIZE) {
			System.out.println(VALIDATE_THREE_NUMBER_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/06 12:46 오전
	 * @Description : 사용자가 서로 다른 숫자를 입력했는지 검증
	 *
	 **/
	private static boolean isDuplicateNumber(String input) {
		Set<String> inputSet = new HashSet<>(Arrays.asList(input.split(Checker.INPUT_DELIMITER)));
		if (inputSet.size() != Checker.INPUT_MIN_SIZE) {
			System.out.println(VALIDATE_DUPLICATE_NUMBER_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/06 12:48 오전
	 * @Description : 사용자가 다시 시작 or 완전 종료하기 위해 1, 2를 입력했는지 검증
	 *
	 **/
	private static boolean isRestartNumber(String input) {
		if (!Objects.equals(input, Checker.RESTART_TRUE) && !Objects.equals(input, Checker.RESTART_FALSE)) {
			System.out.println(VALIDATE_RESTART_NUMBER_MESSAGE);
			return false;
		}
		return true;
	}
}
