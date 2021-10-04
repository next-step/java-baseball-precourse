package baseball.model;

import static baseball.model.BallStatus.*;
import static baseball.model.GameStatus.*;

import java.util.Arrays;
import java.util.List;

import baseball.utils.NumberGenerator;

public class BaseballGame {

	private static final int STRIKE_OUT = 3;

	private final Balls question;
	private final BallCount ballCount;
	private final GameStatus gameStatus;

	public BaseballGame(NumberGenerator generator) {
		this.question = Balls.of(generator.generate());
		this.ballCount = BallCount.from(Arrays.asList(NOTHING, NOTHING, NOTHING));
		this.gameStatus = PROGRESS;
	}

	private BaseballGame(Balls balls, BallCount ballCount, GameStatus gameStatus) {
		this.question = balls;
		this.ballCount = ballCount;
		this.gameStatus = gameStatus;
	}

	public BaseballGame hit(List<Integer> inputNumbers) {
		final Balls answer = Balls.of(inputNumbers);
		final BallCount ballCount = question.match(answer);

		if (isOut(ballCount)) {
			return new BaseballGame(this.question, ballCount, END);
		}
		return new BaseballGame(this.question, ballCount, PROGRESS);
	}

	public BallCount getBallCount() {
		return ballCount;
	}

	private boolean isOut(BallCount ballCount) {
		return ballCount.countStrike() == STRIKE_OUT;
	}

	public boolean isFinished() {
		return this.gameStatus == END;
	}
}
