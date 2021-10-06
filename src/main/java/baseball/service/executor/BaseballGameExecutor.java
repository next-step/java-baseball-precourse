package baseball.service.executor;

import static baseball.domain.GameMessagePrinter.*;
import static baseball.service.AnswerMaker.*;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameScoreBoard;
import baseball.domain.GameMessage;
import baseball.service.AnswerMaker;
import nextstep.utils.Console;

public class BaseballGameExecutor {

	public void execute() {

		do {
			BaseballGame baseballGame = new BaseballGame(AnswerMaker.make());
			executeSingleGame(baseballGame);

			println(GameMessage.ASK_RESTART_OR_DONE);
		} while (isRestartGame());
	}

	public void executeSingleGame(BaseballGame baseballGame) {
		do {
			print(GameMessage.ASK_INPUT);
			println(deal(baseballGame));
		} while (isSingleGameContinue(baseballGame));
	}

	private boolean isRestartGame() {

		final String input = Console.readLine();

		if (input.equals("1")) {
			return true;
		}

		if (input.equals("2")) {

			println(GameMessage.END_PROGRAM);
			return false;
		}

		println(GameMessage.ERR_PUT_ONLY_1_OR_2);
		return isRestartGame();
	}

	private BaseballGameScoreBoard deal(BaseballGame baseballGame) {

		String input = Console.readLine();

		if (isValid(input)) {
			return baseballGame.deal(input);
		}

		println(GameMessage.ERR_PUT_ONLY_THREE_NUMBERS);
		print(GameMessage.ASK_INPUT);
		return deal(baseballGame);
	}

	private boolean isSingleGameContinue(BaseballGame baseballGame) {
		if (baseballGame.isContinue()) {
			return true;
		}
		println(GameMessage.END_SINGLE_GAME_WITH_THREE_STRIKES);
		return false;
	}
}
