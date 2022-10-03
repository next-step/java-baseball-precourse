package baseball.service;

import baseball.domain.Hint;

import java.util.Map;

public interface BaseballGameService {
    void startNewGame();

    Map<Hint, Integer> verifyAnswer(String inputNumber);
}
