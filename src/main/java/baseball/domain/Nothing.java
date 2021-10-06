package baseball.domain;

import java.util.NoSuchElementException;

public class Nothing extends GameRule {

    public Nothing() {
        super(Rule.NOTHING);
    }

    @Override
    public String getText() {
        throw new NoSuchElementException(rule.getName());
    }
}
