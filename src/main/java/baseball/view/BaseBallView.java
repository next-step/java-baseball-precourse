package baseball.view;

import nextstep.utils.Console;

public class BaseBallView {

	public static String requestInputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public static void printResult(String result) {
		System.out.println(result);
	}

	public static String replay() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Console.readLine();
	}
}
