package baseball.domain;

import baseball.domain.result.Result;
import baseball.domain.rule.Rule;

public class Baseball {

    private Result result;
    private String randomValue;

    public Baseball(Result result, String randomValue) {
        this.result = result;
        this.randomValue = randomValue;
    }

    public void play(Rule rule, String input) {
        rule.count(input, randomValue, result);
    }

    public String result() {
        return result.result();
    }

    public boolean isComplete() {
        return result.isComplete();
    }
}
