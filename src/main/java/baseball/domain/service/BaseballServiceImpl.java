package baseball.domain.service;

import baseball.domain.Baseball;
import baseball.domain.repository.BaseballRepository;
import baseball.domain.result.BallResult;
import baseball.domain.result.DefaultResult;
import baseball.domain.result.Result;
import baseball.domain.result.StrikeResult;
import baseball.domain.rule.Rule;
import java.util.List;

public class BaseballServiceImpl implements BaseballService {

    private final BaseballRepository repository;
    private final List<Rule> rules;

    public BaseballServiceImpl(BaseballRepository repository, List<Rule> rules) {
        this.repository = repository;
        this.rules = rules;
    }

    @Override
    public void saveBaseball(String randomValue) {
        Baseball baseball = new Baseball(getResult(), randomValue);
        repository.save(baseball);
    }

    @Override
    public void playBaseball(String input) {
        Baseball baseball = repository.find();
        for (Rule rule : rules) {
            baseball.play(rule, input);
        }
    }

    @Override
    public String resultBaseball() {
        Baseball baseball = repository.find();
        return baseball.result();
    }

    @Override
    public boolean isComplete() {
        Baseball baseball = repository.find();
        return baseball.isComplete();
    }

    private Result getResult() {
        return new BallResult(new StrikeResult(new DefaultResult()));
    }
}
