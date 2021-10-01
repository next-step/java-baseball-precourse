package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class User {

	private List input = new ArrayList<Integer>();

	public List getInput() {
		clear();
		inputNumber();
		return input;
	}

	private void inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String readLine = Console.readLine();

		for (int i = 0; input.size() != 3; i++) {
			int parseInt = Integer.parseInt(String.valueOf(readLine.charAt(i)));
			input.add(parseInt);
		}
	}

	private void clear() {
		if (!input.isEmpty()) {
			input.clear();
		}
	}

}
