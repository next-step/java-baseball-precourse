package baseball.view;

import nextstep.utils.Console;

public class InputMessage {

	public static void inputNumberMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public static String inputRestart() {
		return Console.readLine();
	}
}
