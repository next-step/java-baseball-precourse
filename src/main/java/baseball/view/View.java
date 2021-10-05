package baseball.view;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class View {
	private View() {
	}

	private static final View instance = new View();

	public static View getInstance() {
		return instance;
	}

	public List<Integer> inputThreeNumbers() {
		String input;
		do {
			System.out.print("숫자를 입력해주세요: ");
			input = Console.readLine();

		} while (!validateIfThreeNumbers(input));

		return convertToIntegerList(input);
	}

	private boolean validateIfThreeNumbers(String input) {
		if (input.length() == 3 && isPossibleParseInt(input)) {
			return true;
		}
		outputErrorAboutThreeNumbers();
		return false;
	}

	private boolean isPossibleParseInt(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

	public void outputErrorAboutThreeNumbers() {
		System.out.println("[ERROR] 숫자 3자리로 입력해야 합니다.");
	}

	private List<Integer> convertToIntegerList(String str) {
		List<Integer> result = new ArrayList<>();

		char[] chars = str.toCharArray();
		for (char aChar : chars) {
			result.add(aChar - 48);
		}

		return result;
	}

	public void outputResult(String message) {
		System.out.println(message);
	}

	public void outputEnd() {
		System.out.println("게임 끝");
	}

	public int inputRestartOrEndNumber() {
		String input = null;
		while (input == null || !validateIfItIsOneOrTwo(input)) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = Console.readLine();
		}

		return Integer.parseInt(input);
	}

	private boolean validateIfItIsOneOrTwo(String input) {
		if (input.length() == 1 && isPossibleParseIntAndNumberOneOrTwo(input)) {
			return true;
		}

		outputErrorAboutRestartOrEnd();
		return false;
	}

	private void outputErrorAboutRestartOrEnd() {
		System.out.println("[ERROR] 숫자 1 또는 2만 입력 가능합니다.");
	}

	private boolean isPossibleParseIntAndNumberOneOrTwo(String input) {
		try {
			int number = Integer.parseInt(input);
			if (isNumberOneOrTwo(number)) {
				return false;
			}

		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

	private boolean isNumberOneOrTwo(int number) {
		return number != 1 && number != 2;
	}
}
