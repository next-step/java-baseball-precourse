package baseball.view;

import baseball.domain.Hint;

import java.util.Map;

public interface BaseballGameView {
    String inputCandidateNumber();

    void displayResult(Map<Hint, Integer> hintMap);

    String isContinueGame();

    void endGame();

    void correctAnswer();
}
