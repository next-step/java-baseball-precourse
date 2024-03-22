package presentation;

import java.util.Scanner;

import domain.Score;

public class InputReceiver {
	private final static Scanner scanner = new Scanner(System.in);

	/**
	 * 플레이어가 문제를 맞히기 위해 입력하는 입력값을 받습니다.
	 * @return
	 */
	public String getPlayerInput() {
		while (true) {
			try {
				System.out.print("숫자를 입력해주세요 : ");
				String input = scanner.nextLine();
				validateInput(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 숫자로 구성된 3자리 숫자를 입력해주세요!!");
			}
		}
	}

	/**
	 * 플레이어의 게임 재시작 여부에 대한 입력을 받습니다.
	 * @return
	 */
	public boolean getRestartInput() {
		while (true) {
			try {
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				String input = scanner.nextLine();
				validateRestartInput(input);
				return input.equals("1");
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 게임 재시작 여부에 따라 1 혹은 2를 입력해주세요!");
			}
		}
	}

	/**
	 * 길이 3의 숫자로 된 문자열이 맞는지 검증합니다.
	 * @param input
	 */
	private void validateInput(String input) {
		if (input.length() != Score.ANSWER_LENGTH) {
			throw new IllegalArgumentException();
		}
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void validateRestartInput(String input) {
		if (!input.equals("1") && !input.equals("2")) {
			throw new IllegalArgumentException();
		}
	}
}
