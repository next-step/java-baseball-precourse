package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BallNumbers {

	private static final int SIZE = 3;
	private List<Ball> ballNumbers;

	private BallNumbers(List<Ball> ballNumbers) {
		this.ballNumbers = ballNumbers;
	}

	private static boolean isValidSize(Set<Ball> ballNumbers) {
		return ballNumbers.size() == SIZE;
	}

	private static String isValidNo(String numbers) {
		try {
			Integer.parseInt(numbers);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
		return numbers;
	}

	private static List<Ball> stringToList(String numbers) {
		String[] splitNumbers = numbers.split("");
		List<Ball> ballNumbers = new ArrayList<>();
		for (String s : splitNumbers) {
			ballNumbers.add(Ball.of(Integer.parseInt(s)));
		}

		return ballNumbers;
	}

	public static BallNumbers fromSet(Set<Ball> ballNumbers) {
		return new BallNumbers(new ArrayList<>(ballNumbers));
	}

	public static BallNumbers of(String numbers) {
		List<Ball> ballNumbers = stringToList(isValidNo(numbers));
		Set<Ball> ballNumberSet = new LinkedHashSet<>(ballNumbers);

		if (!isValidSize(ballNumberSet)) {
			throw new IllegalArgumentException("중복되지 않는 3자리 수를 입력해야 합니다.");
		}

		return new BallNumbers(ballNumbers);
	}

	public List<Ball> getBallNumbers() {
		return this.ballNumbers;
	}

	public boolean isContains(Ball number) {
		return ballNumbers.contains(number);
	}

	public boolean isEqualFromIndex(Ball number, int index) {
		return ballNumbers.get(index).equals(number);
	}

}