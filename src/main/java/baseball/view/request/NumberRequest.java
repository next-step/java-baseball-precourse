package baseball.view.request;

import java.util.regex.Pattern;

public class NumberRequest {
	private static final String PATTERN = "^[1-9]{3}";
	private final String numbers;

	public NumberRequest(final String numbers) throws IllegalArgumentException {
		this.numbers = validation(numbers);
	}

	public String getNumbers() {
		return numbers;
	}

	private String validation(final String value) {
		if (!Pattern.matches(PATTERN, value)) {
			throw new IllegalArgumentException("[ERROR] 잘못 입력하셨습니다. 1-9범위의 숫자 중 3자리의 숫자만 입력해주세요.");
		}
		return value;
	}
}
