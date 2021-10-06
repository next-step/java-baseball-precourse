package baseball.domain;

public class Strike {

    private static final int ZERO = 0;
    private static final String EMPTY = "";

    private final Rule rule;
    private final int count;

    public Strike(int count) {
        this.rule = Rule.STRIKE;
        this.count = count;
    }

    public String getText() {
        if (count == ZERO) {
            return EMPTY;
        }
        return this.rule.getText(count);
    }
}
