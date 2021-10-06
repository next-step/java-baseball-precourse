package baseball.utils;

import baseball.domain.Message;
import nextstep.utils.Console;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {

	private static final String ballsPattern = "^[1-9]{3}$";
	private static final String ballsExitOrRestartPattern = "^[1-2]{1}$";
	public final static int BALL_COUNT_LENGTH = 3;

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

	private static boolean checkBallsPattern(String input) {
		if (input == null || (input != null && !Pattern.matches(ballsPattern, input))) {
			System.out.println(Message.INPUT_ERROR.getValue());
			return false;
		}
		if (!checkDuplication(input)) return false;
		return true;
	}

	private static boolean checkExitOrRestartPattern(String input) {
		if (input == null || (input != null && !Pattern.matches(ballsExitOrRestartPattern, input))) {
			System.out.println(Message.INPUT_ERROR.getValue());
			return false;
		}
		return true;
	}

	private static boolean checkDuplication(String input) {
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