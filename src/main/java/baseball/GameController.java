package baseball;

import baseball.dto.MatchResult;
import baseball.dto.Numbers;

public interface GameController {
	public void gameStartMenu();

	public MatchResult match(Numbers randomNumbers, int userInput);

	public void playGame();

	public int getUserInput();
}
