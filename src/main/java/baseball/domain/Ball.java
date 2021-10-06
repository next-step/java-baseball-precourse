package baseball.domain;

public class Ball extends GameRule {

    private final int count;

    public Ball(int count) {
        super(Rule.BALL);
        this.count = count;
    }

    @Override
    public String getText() {
        if (count == ZERO) {
            return EMPTY;
        }
        return rule.getText(count);
    }
}
