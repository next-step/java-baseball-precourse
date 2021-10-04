package baseball.view;

import java.io.PrintStream;

public class OutputView {

	private static final PrintStream OUTPUT = System.out;

	public void printInputNumber() {
		OUTPUT.print("숫자를 입력해주세요 : ");
	}
}
