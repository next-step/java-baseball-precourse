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
}
