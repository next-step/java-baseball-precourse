package baseball;

import baseball.domain.Checker;
import baseball.domain.Examiner;
import baseball.domain.Numbers;
import baseball.domain.Player;
import baseball.type.GameStatus;
import baseball.view.InputMessage;
import baseball.view.OutputMessage;

public class Game {

	private static final String RESTART_CODE = "1";
	private static final String END_CODE = "2";

	private final Player player;

	private final Examiner examiner;

	private final Checker checker;

	private GameStatus gameStatus;

	public Game() {
		this.player = new Player();
		this.examiner = new Examiner();
		this.checker = new Checker();
		this.gameStatus = GameStatus.START;
	}

	public Game(Player player, Examiner examiner, Checker checker) {
		this.player = player;
		this.examiner = examiner;
		this.checker = checker;
		this.gameStatus = GameStatus.START;
	}

	public void start(){

		while(!this.gameStatus.equals(GameStatus.END)) {
			play();
		}

	}

	private void askRestart() {
		OutputMessage.printGameEndMessage();
		String restartCode = InputMessage.inputRestart();

		if(restartCode.equals(RESTART_CODE)) {
			changeGameStatus(GameStatus.START);
		} else {
			changeGameStatus(GameStatus.END);
		}
	}

	private void play(){
		Numbers goal = examiner.getGoal();

		do {
			InputMessage.inputNumberMessage();
			player.inputAnswer();

			Numbers answer = player.getAnswer();
			checker.answerCheck(answer, goal);

			OutputMessage.printHint(checker.getStrike(), checker.getBall());

		} while (!checker.isAllStrike());

		askRestart();
	}

	private void changeGameStatus(GameStatus status) {
		this.gameStatus = status;
	}

}
