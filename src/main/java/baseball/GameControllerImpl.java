package baseball;

import java.util.Scanner;

import baseball.dto.MatchResult;
import baseball.dto.Numbers;

public class GameControllerImpl implements GameController {
	private final GameUI gameUI = new GameUIImpl();
	private final GameLogic gameLogic = new GameLogicImpl();

	public void gameStartMenu() {
		while (true) {
			gameUI.printStartOrStop();
			int userInput = getUserInput();

			if (userInput == 1) {
				playGame();
				continue;
			}
			if (userInput == 2) {
				break;
			}

			gameUI.printError();
		}
	}

	public void playGame() {
		Numbers randomNumbers = gameLogic.createRandomNumbers();
		MatchResult matchResult = new MatchResult();

		while (matchResult.strike < 3) {
			gameUI.printRequireUserInput();
			int userInput = getUserInput();

			if (userInput < 100 || userInput > 999) {
				gameUI.printError();
				continue;
			}

			matchResult = match(randomNumbers, userInput);
		}
		gameUI.printFinished();
	}

	public MatchResult match(Numbers randomNumbers, int userInput) {
		Numbers userInputNumbers = gameLogic.createNumbersFromUserInput(userInput);
		MatchResult matchResult = gameLogic.matchNumbers(randomNumbers, userInputNumbers);

		gameUI.printMatchResult(matchResult);

		return matchResult;
	}

	public int getUserInput() {
		Scanner scanner = new Scanner(System.in);

		try {
			return scanner.nextInt();
		} catch (Exception e) {
			return -1;
		}
	}
}
