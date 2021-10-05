package baseball.view.request;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumberRequest {
	private static final String PATTERN = "^[1-9]{3}";
	private final List<Integer> numbers;

	public NumberRequest(final String numbers) throws IllegalArgumentException {
		this.numbers = convertNumbers(validation(numbers));
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private List<Integer> convertNumbers(final String input) {
		String[] inputArr = input.split("");
		List<Integer> numbers = new ArrayList<>();
		for (String s : inputArr) {
			numbers.add(Integer.valueOf(s));
		}
		return numbers;
	}

	private String validation(final String value) {
		if (!Pattern.matches(PATTERN, value)) {
			throw new IllegalArgumentException("[ERROR] 잘못 입력하셨습니다. 1-9범위의 숫자 중 3자리의 숫자만 입력해주세요.");
		}
		return value;
	}
}
