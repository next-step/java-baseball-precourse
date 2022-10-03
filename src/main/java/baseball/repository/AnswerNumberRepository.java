package baseball.repository;

import baseball.domain.Answer;

public interface AnswerNumberRepository {
    void save(Answer answer);

    Answer findAnswerNumber();

    void clearStore();
}
