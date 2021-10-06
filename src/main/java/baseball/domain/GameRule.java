package baseball.domain;

public abstract class GameRule {

    protected static final int ZERO = 0;
    protected static final String EMPTY = "";

    protected final Rule rule;

    public GameRule(Rule rule) {
        this.rule = rule;
    }

    abstract String getText();
}
