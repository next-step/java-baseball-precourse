package baseball.domain.rule;

import baseball.domain.result.Result;

public interface Rule {

    int count(String input, String randomValue, Result result);
}
