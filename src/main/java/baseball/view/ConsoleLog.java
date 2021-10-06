package baseball.view;

import baseball.view.request.MenuRequest;
import baseball.view.request.NumberRequest;
import baseball.view.response.ScoreResponse;
import nextstep.utils.Console;

public class ConsoleLog {
	private ConsoleLog() {
	}

	public static NumberRequest getInputNumber() throws IllegalArgumentException {
		System.out.println("숫자를 입력해주세요.");
		return new NumberRequest(Console.readLine());
	}

	public static void printScore(final ScoreResponse scoreResponse) {
		System.out.println(scoreResponse.getMessage());
	}

	public static void printGameClear() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	public static MenuRequest getInputMenu() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return new MenuRequest(Console.readLine());
	}
}
