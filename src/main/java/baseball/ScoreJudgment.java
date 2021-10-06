package baseball;

import com.sun.javafx.binding.StringFormatter;

public class ScoreJudgment {
	public String judgment(BaseballNumbers playerNumbers, BaseballNumbers computerNumbers) {
		int countOfSameNumber = playerNumbers.countSameNumber(computerNumbers);
		int countOfStrike = playerNumbers.countSameNumberAndLocation(computerNumbers);
		int countOfBall = countOfSameNumber - countOfStrike;

		if (countOfStrike != 0 && countOfBall != 0) {
			return StringFormatter.format("%d스트라이크 %d볼", countOfStrike, countOfBall)
				.get();

		}

		if (countOfStrike != 0) {
			return StringFormatter.format("%d스트라이크", countOfStrike)
				.get();
		}

		if (countOfBall != 0) {
			return StringFormatter.format("%d볼", countOfBall)
				.get();
		}
		return "낫싱";
	}
}
