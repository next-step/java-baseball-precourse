package baseball;

import nextstep.utils.Console;

public class BaseBall {
	private static int strikeCount;
	private static int ballCount;

	public void run() {
		String generate = RandomNumberGenerator.generate();
		strikeCount = 0;
		ballCount = 0;

		while (strikeCount != 3) {
			computed(inNumber(), generate);
			outputPrint();
		}
		restart();
	}

	private void restart() {
		String trigger = restartQuestion();
		if (trigger.equals("1")) {
			new BaseBall().run();
		}
		if (trigger.equals("2")) {
			System.out.println("게임을 종료합니다");
			System.exit(0);
		}
	}

	private void computed(String inputs, String generate) {
		for (int i = 0; i < inputs.length(); i++) {
			isBall(inputs, generate, i);
			isStrike(inputs, generate, i);
		}
	}

	private void isBall(String inputs, String generate, int idx) {
		if (inputs.charAt(idx) != generate.charAt(idx) && generate.contains(Character.toString(inputs.charAt(idx)))) {
			ballCount++;
		}
	}

	private void isStrike(String inputs, String generate, int idx) {
		if (inputs.charAt(idx) == generate.charAt(idx)) {
			strikeCount++;
		}
	}

	private String inNumber() {
		System.out.print("숫자를 입력해 주세요 : ");
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
