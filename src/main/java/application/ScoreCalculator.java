package application;

import domain.Score;

public class ScoreCalculator {
	/**
	 * 두 숫자 문자열을 비교하여 점수를 반환합니다.
	 * @param answer 정답
	 * @param input 플레이어 입력
	 * @return
	 */
	public Score calculate(String answer, String input) {
		Score score = new Score();

		for (int i = 0; i < Score.ANSWER_LENGTH; i++) {
			if (input.charAt(i) == answer.charAt(i)) {
				score.addStrikeCount();
				continue;
			}
			if (answer.contains(String.valueOf(input.charAt(i)))) {
				score.addBallCount();
			}
		}

		return score;
	}
}
