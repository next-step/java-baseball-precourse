package baseball;

import baseball.dto.MatchResult;
import baseball.dto.Numbers;


public interface GameLogic {
	public Numbers createRandomNumbers();

	public Numbers createNumbersFromUserInput(int userInput);

	public MatchResult matchNumbers(Numbers randomNumber, Numbers userInput);
}
