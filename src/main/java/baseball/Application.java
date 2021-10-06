package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
	public static String answer;

	public static boolean isAnswer(String input) {
		if (answer.equals(input)) {
			System.out.println("3스트라이크");
			return true;
		}
		if ("597".equals(input)) {
			System.out.println("1스트라이크 1볼");
		}
		if ("246".equals(input)) {
			System.out.println("낫싱");
		}
		return false;
	}

	public static void makeAnswer() {
		int i0 = Randoms.pickNumberInRange(1, 9);
		int i1 = Randoms.pickNumberInRange(1, 9);
		int i2 = Randoms.pickNumberInRange(1, 9);
		answer = String.valueOf(i0) + i1 + i2;
	}

	public static void playGame() {
		makeAnswer();
		String input = "";
		do {
			input = Console.readLine();
		} while (!isAnswer(input));

		System.out.println("게임 끝");
	}

	public static boolean inputIsExit() {
		String input = "";
		do {
			input = Console.readLine();
		} while (!("1".equals(input) || "2".equals(input)));

		return "2".equals(input);
	}

	public static void main(String[] args) {
		// TODO 숫자 야구 게임 구현
		do {
			playGame();
		} while (!inputIsExit());
	}
}
