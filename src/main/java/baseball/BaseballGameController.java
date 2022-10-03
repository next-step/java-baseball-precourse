package baseball;

import static baseball.GameStatus.*;
import static baseball.View.*;

import java.util.ArrayList;
import java.util.List;

import baseball.computer.ComputerService;
import camp.nextstep.edu.missionutils.Console;

/**
 * @author garden.iee
 */
public class BaseballGameController {

	private List<Integer> computerOutput;

	public void run() {
		do {
			ComputerService computerService = new ComputerService();
			computerOutput = computerService.getComputerOutput();
			play();
		} while (isRestartedGame());
	}

	private void play() {
		while (true) {
			printRequest();
			Hint hint = new Hint(computerOutput, getUserInput());
			printHint(hint);
			if (isFinishedGame(hint)) {
				printFinish();
				break;
			}
		}
	}

	private List<Integer> getUserInput() {
		List<Integer> userInput = new ArrayList<>();
		String input = Console.readLine();
		for (int i = 0; i < input.length(); i++) {
			userInput.add(Integer.parseInt(String.valueOf(input.charAt(i))));
		}
		return userInput;
	}

	private boolean isFinishedGame(Hint hint) {
		return hint.isThreeStrike();
	}

	private boolean isRestartedGame() {
		printRestartOrFinish();
		return RESTART.getValue() == Integer.parseInt(Console.readLine());
	}
}