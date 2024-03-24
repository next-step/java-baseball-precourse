package baseball;

import baseball.dto.MatchResult;

public interface GameUI {
	public void printStartOrStop();

	public void printRequireUserInput();

	public void printMatchResult(MatchResult matchResult);

	public void printFinished();

	public void printError();
}
