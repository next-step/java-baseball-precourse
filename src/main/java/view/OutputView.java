package view;

public class OutputView {
	public static void displayCount(int strike, int ball) {
		String result = "";
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
			return;
		}
		if (strike != 0) {
			result += strike + "스트라이크 ";
		}
		if (ball != 0) {
			result += ball + "볼";
		}
		System.out.println(result);
	}

	public static void displayErrorMessage(String errorMessage) {
		System.out.printf("[ERROR] %s%n", errorMessage);
	}

	public static void displayEndMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}
}
