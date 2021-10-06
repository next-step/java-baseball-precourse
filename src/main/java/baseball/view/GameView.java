package baseball.view;

import baseball.errors.InvalidLengthException;
import baseball.errors.NotANumberException;
import baseball.errors.UnboundRangeException;
import baseball.model.CompareResult;
import nextstep.utils.Console;

public class GameView {
	public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String MENU_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String CORRECT_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 끝";
	public static final String ERROR_PREFIX = "[ERROR]";
	public static final int MENU_LENGTH = 1;
	public static final int ANSWER_LENGTH = 3;

	public String InputMenuMessage() {
		String input = "";
		do {
			System.out.println(MENU_MESSAGE);
			input = Console.readLine();
		} while (isValidMenu(input));
		return input;
	}

	public String inputAnswerMessage() {
		String input = "";
		do {
			System.out.println(INPUT_MESSAGE);
			input = Console.readLine();
		} while (isValid(input));
		return input;
	}

	public void printResult(CompareResult result) {
		if (result.isNothing()) {
			System.out.println("낫싱");
			return;
		}

		System.out.println(result.getStrike() + "스트라이크 " + result.getBall() + "볼");
		if (result.isAnswer()) {
			System.out.println(ANSWER_LENGTH + CORRECT_MESSAGE);
		}
	}

	private boolean checkInvalidLength(String input, int length) {
		if (input.length() != length) {
			throw new InvalidLengthException(length);
		}
		return true;
	}

	private boolean checkNotANumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new NotANumberException();
		}
		return true;
	}

	private boolean checkUnboundRange(String input, int from, int to) {
		int i = Integer.parseInt(input);
		if (i < from || i > to) {
			throw new UnboundRangeException(from, to);
		}
		return true;
	}

	private boolean checkLengthAndNumber(String input, int length) {
		return checkInvalidLength(input, length) && checkNotANumber(input);
	}

	private boolean isValid(String input) {
		try {
			return checkLengthAndNumber(input, ANSWER_LENGTH);
		} catch (InvalidLengthException | NotANumberException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
		}

		return false;
	}

	private boolean isValidMenu(String input) {
		try {
			return checkLengthAndNumber(input, MENU_LENGTH) && checkUnboundRange(input, 1, 2);
		} catch (InvalidLengthException | NotANumberException | UnboundRangeException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
		}

		return false;
	}
}
