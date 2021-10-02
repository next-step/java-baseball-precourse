package domain;

import static domain.GameStatus.*;

public class Game {

	private static final int CORRECT_NUMBER = 3;

	private int strike;
	private int ball;
	private GameStatus gameStatus;

	public Game() {
		gameStatus = NOTHING;
	}

	public void addStike() {
		this.strike++;

		if (strike == CORRECT_NUMBER) {
			gameStatus = CORRECT;
		}

		if (gameStatus == NOTHING) {
			gameStatus = INCORRECT;
		}
	}

	public void addBall() {
		this.ball++;
		if (gameStatus == NOTHING) {
			gameStatus = INCORRECT;
		}
	}

	public GameStatus getGameStatus() {
		return this.gameStatus;
	}

	@Override
	public String toString() {

		if (gameStatus == NOTHING) {
			return "낫싱";
		}

		if (gameStatus == CORRECT) {
			return String.format("%d개의 숫자를 모두 맞히셨습니다! 게임끝", CORRECT_NUMBER);
		}

		if (gameStatus == INCORRECT) {

			if (strike == 0) {
				return String.format("%d볼", ball);
			}

			if (ball == 0) {
				return String.format("%d스트라이크", strike);
			}

			return String.format("%d스트라이크 %d볼", strike, ball);
		}

		throw new IllegalStateException("Unknown Game Status");
	}
}
