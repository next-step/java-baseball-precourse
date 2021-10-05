package baseball.view;

import baseball.view.request.NumberRequest;
import baseball.view.response.ScoreResponse;
import nextstep.utils.Console;

public class ConsoleLog {
	public static NumberRequest getInputNumber() throws IllegalArgumentException {
		System.out.println("숫자를 입력해주세요.");
		return new NumberRequest(Console.readLine());
	}

	public static void printScore(final ScoreResponse scoreResponse) {
		System.out.println(scoreResponse.getMessage());
	}
}
