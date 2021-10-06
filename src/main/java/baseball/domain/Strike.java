package baseball.domain;

public class Strike extends GameRule {

    private int count;

    public Strike(int count) {
        super(Rule.STRIKE);
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
        return this.rule.getText(count);
    }
}
