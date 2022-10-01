package baseball.view;

import java.util.List;

import baseball.util.InputUtil;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public List<Integer> inputNumbers() {
		printMessage(USER_INPUT_MESSAGE);
		return InputUtil.getUserNumbers(readLine());
	}

	private String readLine() {
		return Console.readLine();
	}

	public String inputRestart() {
		printMessage(RESTART_INPUT_MESSAGE + InputUtil.NEXT_LINE);
		return readLine();
	}

	private void printMessage(String message) {
		System.out.print(message);
	}
}
