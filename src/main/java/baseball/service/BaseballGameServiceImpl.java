package baseball.service;

import baseball.domain.Answer;
import baseball.domain.Candidate;
import baseball.domain.Hint;
import baseball.repository.AnswerNumberRepository;

import java.util.Map;

public class BaseballGameServiceImpl implements BaseballGameService {
    private final AnswerNumberRepository answerNumberRepository;

    public BaseballGameServiceImpl(AnswerNumberRepository answerNumberRepository) {
        this.answerNumberRepository = answerNumberRepository;
    }

    @Override
    public void startNewGame() {
        answerNumberRepository.clearStore();

        Answer answer = Answer.createAnswer();
        answerNumberRepository.save(answer);
    }

    @Override
    public Map<Hint, Integer> verifyAnswer(String candidateNumber) {
        Candidate candidate = Candidate.createCandidateNumber(candidateNumber);
        Answer answer = answerNumberRepository.findAnswerNumber();
        Map<Hint, Integer> hintMap = answer.verifyAnswer(candidate);

        return hintMap;
    }
}
