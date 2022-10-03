package baseball.utils;

public class Validator {
	public boolean checkUserInputNum(String num, int lenLimit, int minInclusive, int maxInclusive) throws IllegalArgumentException {
		try {
			isOnlyNum(num);
			isMatchLength(num, lenLimit);
			isInScope(num, minInclusive, maxInclusive);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			throw e;
		}

		return true;
	}

	// 예외 확인 메소드1 - 숫자 검사
	private void isOnlyNum(String input) throws IllegalArgumentException {
		if (!input.matches("[0-9]+")) {
			throw new IllegalArgumentException("[ERROR] 숫자 이외의 문자는 입력할 수 없습니다.");
		}
	}

	// 예외 확인 메소드2 - 길이 검사
	private void isMatchLength(String input, int len) throws IllegalArgumentException {
		if (input.length() != len) {
			throw new IllegalArgumentException(String.format("[ERROR] %d자리 숫자로 입력해 주십시오.", len));
		}
	}

	// 예외 확인 메소드3 - 범위 검사
	private void isInScope(String input,int minInclusive, int maxInclusive) throws IllegalArgumentException {
		for (int i = 0; i < input.length(); i++) {
			isInScopeByChar(input.charAt(i), minInclusive, maxInclusive);
		}
	}

	private void isInScopeByChar(char c, int minInclusive, int maxInclusive) throws IllegalArgumentException {
		if (c-'0' < minInclusive || c-'0' > maxInclusive) {
			throw new IllegalArgumentException(String.format("[ERROR] %d부터 %d까지 입력 가능합니다.", minInclusive, maxInclusive));
		}
	}
}
