package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class BallNumberSet {

	private static final int SIZE = 3;
	private Set<BallNumber> ballNumberSet;

	private BallNumberSet(Set<BallNumber> ballNumberSet) {
		this.ballNumberSet = ballNumberSet;
	}

	private static boolean validSize(Set<BallNumber> ballNumberSet){
		return ballNumberSet.size() == SIZE;
	}

	private static Set<BallNumber> setNumber(String numbers) {
		Set<BallNumber> ballNumberSet = new HashSet<>();
		String[] splitNumbers = numbers.split("");

		for (String number : splitNumbers) {
			ballNumberSet.add(BallNumber.of(Integer.parseInt(number)));
		}

		return ballNumberSet;
	}

	public static BallNumberSet of(String numbers) {
		Set<BallNumber> ballNumberSet = setNumber(numbers);

		if(!validSize(ballNumberSet)) {
			throw new IllegalArgumentException("중복되지 않는 3자리 수를 입력해야 합니다.");
		}

		return new BallNumberSet(ballNumberSet);
	}
}