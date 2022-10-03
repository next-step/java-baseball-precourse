package baseball.app;

import static baseball.message.ErrorMessage.INPUT_ENDED_ERROR;
import static baseball.util.BallNumberUtils.toBallNumbers;
import static baseball.util.RandomNumberUtils.generateNoneDuplicatedNumberList;

import java.util.List;

import baseball.io.Input;
import baseball.io.Output;
import baseball.message.GameMessage;
import baseball.model.Balls;
import baseball.model.PlayResult;

public class BaseBallGame {
	private static final String RE_GAME = "1";
	private static final String EXIT = "2";
	private static final int BALL_COUNT = 3;
	private static final int MIN_BALL_NO = 1;
	private static final int MAX_BALL_NO = 9;

	private final Input input;
	private final Output output;

	private boolean isPlaying = true;
	private Balls computer;

	public BaseBallGame(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	public void play() {
		computer = generateRandomBalls();

		while (isPlaying) {
			String userBalls = input.getUserBalls();
			List<Integer> userNumbers = toBallNumbers(userBalls, MIN_BALL_NO, MAX_BALL_NO, BALL_COUNT);
			PlayResult result = computer.play(userNumbers);
			output.printResult(result);

			if (result.isGameEnd()) {
				endedGame();
			}
		}
	}

	private void endedGame() {
		output.printMessage(GameMessage.GAME_END);
		String command = input.getEndCommand();
		if (command.equals(RE_GAME)) {
			computer = generateRandomBalls();
		} else if (command.equals(EXIT)) {
			isPlaying = false;
		} else {
			throw new IllegalArgumentException(INPUT_ENDED_ERROR.toString());
		}
	}

	private Balls generateRandomBalls() {
		return new Balls(generateNoneDuplicatedNumberList(MIN_BALL_NO, MAX_BALL_NO, BALL_COUNT));
	}
}
