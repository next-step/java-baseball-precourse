package baseball.domain;

public class Ball extends GameRule {

    private int count;

    public Ball(int count) {
        super(Rule.BALL);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void count() {
        this.count++;
    }

    @Override
    public String getText() {
        if (count == ZERO) {
            return EMPTY;
        }
        return rule.getText(count);
    }
}
