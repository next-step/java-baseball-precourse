package presentation;

import application.ScoreCalculator;
import domain.AnswerGenerator;
import domain.Score;

public class BaseBallController {
	private final InputReceiver inputReceiver;
	private final ScoreCalculator scoreCalculator;
	private final AnswerGenerator answerGenerator;

	public BaseBallController(InputReceiver inputReceiver,
		ScoreCalculator scoreCalculator,
		AnswerGenerator answerGenerator) {
		this.inputReceiver = inputReceiver;
		this.scoreCalculator = scoreCalculator;
		this.answerGenerator = answerGenerator;
	}

	/**
	 * 사용자가 정답을 맞힐 때까지 숫자를 입력받으며 점수를 출력합니다.
	 */
	public void start() {
		String answer = answerGenerator.generateAnswer();

		while (true) {
			String input = inputReceiver.getPlayerInput();
			Score score = scoreCalculator.calculate(answer, input);
			if (score.isFinished()) {
				break;
			}
			System.out.println(score.generateScoreMessage());
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	/**
	 * 게임을 재시작할 것인지 여부를 반환합니다.
	 * @return
	 */
	public boolean isRestart() {
		return inputReceiver.getRestartInput();
	}
}
