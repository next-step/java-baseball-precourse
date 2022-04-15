package baseball.game;

import baseball.answer.Answer;

public interface GameService {
    GameRoundResult compareAnswer(Answer answer, Answer inputAnswer);
}
