package baseball.utils;

import baseball.domain.Message;
import nextstep.utils.Console;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public class Validation {

	private static final String ballsPattern = "^[1-9]{3}$";
	private static final String ballsExitOrRestartPattern = "^[1-2]{1}$";
	public final static int BALL_COUNT_LENGTH = 3;

	/**
	 * Gamer가 입력한 공의 유효성 검사
	 * @return String
	 */
	public static String checkInputBalls() {
		boolean checkFlag = false;
		String input = null;
		while (!checkFlag) {
			System.out.println(Message.INPUT.getValue());
			input = Console.readLine();
			checkFlag = checkBallsPattern(input);
		}
		return input;
	}

	/**
	 * 게임 종료 및 재시작 입력 값 유효성 검사
	 * @return String
	 */
	public static String checkInputExitOrRestart() {
		boolean checkFlag = false;
		String input = null;
		while (!checkFlag) {
			System.out.println(Message.EXIT_RESTART.getValue());
			input = Console.readLine();
			checkFlag = checkExitOrRestartPattern(input);
		}
		return input;
	}

	/**
	 * Gamer가 입력한 공에 유효 패턴 검사
	 * @param input
	 * @return boolean
	 */
	private static boolean checkBallsPattern(String input) {
		if (input == null || (input != null && !Pattern.matches(ballsPattern, input))) {
			System.out.println(Message.INPUT_ERROR.getValue());
			return false;
		}
		if (!checkBallsDuplication(input)) return false;
		return true;
	}

	/**
	 * 게임 종료 및 재시작 입력 값 유효 패턴 검사
	 * @param input
	 * @return boolean
	 */
	private static boolean checkExitOrRestartPattern(String input) {
		if (input == null || (input != null && !Pattern.matches(ballsExitOrRestartPattern, input))) {
			System.out.println(Message.INPUT_ERROR.getValue());
			return false;
		}
		return true;
	}

	/**
	 * Gamer가 입력한 공의 중복값 검사
	 * @param input
	 * @return boolean
	 */
	private static boolean checkBallsDuplication(String input) {
		Set<Character> inputSet = new LinkedHashSet();
		for (char inputChar : input.toCharArray())
			inputSet.add(inputChar);
		if (inputSet.size() != BALL_COUNT_LENGTH) {
			System.out.println(Message.INPUT_ERROR.getValue());
			return false;
		}
		return true;
	}
	
}