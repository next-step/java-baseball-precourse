package baseball.controller;

import java.util.List;

import baseball.model.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

	private final InputView inputView;
	private final OutputView outputView;

	public GameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void play() {

		boolean isContinue = true;
		while (isContinue) {

			// 게임 시작
			// 문제 생성
			BaseballGame game = startGame();
			boolean isContinuedRound = true;
			while (isContinuedRound) {
				// 숫자를 입력해주세요:
				this.outputView.printInputNumber();
				// 입력받음
				final List<Integer> inputNumbers = this.inputView.inputNumbers();
				game = game.hit(inputNumbers);

				// 결과 출력
				this.outputView.printGameResult(game.getBallCount());
				// 3스트라이크라면 게임종료
				isContinuedRound = !game.isFinished();
			}

			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			// 재시작 여부 확인
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			isContinue = this.inputView.inputEndNumber();
		}

	}

	private BaseballGame startGame() {
		return new BaseballGame();
	}
}
