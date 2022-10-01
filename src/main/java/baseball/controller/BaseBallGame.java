package baseball.controller;

import java.util.List;

import baseball.enums.RestartStatus;
import baseball.enums.ResultStatus;
import baseball.model.BallNumbers;
import baseball.model.Computer;
import baseball.model.Result;
import baseball.model.Score;
import baseball.model.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGame {

	private final InputView inputView;
	private final OutputView outputView;

	public BaseBallGame() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		BallNumbers computerBallNumbers = getComputerBallNumbers();
		playGame(computerBallNumbers);
		restartGame(inputView.inputRestart());
	}

	private void playGame(BallNumbers computerBallNumbers) {
		Result result;
		do {
			BallNumbers userBallNumbers = getUserBallNumbers();
			ScoreCalculator scoreCalculator = new ScoreCalculator(computerBallNumbers);
			Score score = scoreCalculator.calculateScore(userBallNumbers);
			result = Result.of(score);
			outputView.printResult(result);
		} while (!result.getStatus().equals(ResultStatus.WIN));
	}

	private void restartGame(String restartCode) {
		if (restartCode.equals(RestartStatus.RESTART.getCode())) {
			start();
		}
	}

	private BallNumbers getComputerBallNumbers() {
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.getNumbers();
		return BallNumbers.of(computerNumbers);
	}

	private BallNumbers getUserBallNumbers() {
		List<Integer> userNumbers = inputView.inputNumbers();
		return BallNumbers.of(userNumbers);
	}

}
