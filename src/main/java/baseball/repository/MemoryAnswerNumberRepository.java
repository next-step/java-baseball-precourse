package baseball.repository;

import baseball.domain.Answer;

public class MemoryAnswerNumberRepository implements AnswerNumberRepository {
    private Answer answer;

    @Override
    public void save(Answer answer) {
        this.answer = answer;
    }

    @Override
    public Answer findAnswerNumber() {
        return this.answer;
    }

    @Override
    public void clearStore() {
        this.answer = null;
    }
}
