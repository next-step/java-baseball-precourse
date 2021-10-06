package baseball.domain;

public class Ball {

    private static final int ZERO = 0;
    private static final String EMPTY = "";

    private final Rule rule;
    private final int count;

    public Ball(int count) {
        this.rule = Rule.BALL;
        this.count = count;
    }

    public String getText() {
        if (count == ZERO) {
            return EMPTY;
        }
        return rule.getText(count);
    }
}
