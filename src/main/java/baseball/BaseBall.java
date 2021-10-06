package baseball;

import nextstep.utils.Console;

public class BaseBall {
	private static int strikeCount;
	private static int ballCount;

	private String inNumber() {
		System.out.print("\n숫자를 입력해 주세요 : ");
		return Console.readLine();
	}

	private String restartQuestion() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return Console.readLine();
	}

	private void outputPrint() {
		if (strikeCount != 0) {
			System.out.print(strikeCount + "스트라이크 ");
		}
		if (ballCount != 0) {
			System.out.print(ballCount + "볼");
		}
		if (strikeCount == 0 && ballCount == 0) {
			System.out.print("낫싱");
		}
		if (strikeCount == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
		}
	}
}
