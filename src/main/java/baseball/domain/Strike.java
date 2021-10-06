package baseball.domain;

public class Strike extends GameRule {

    private final int count;

    public Strike(int count) {
        super(Rule.STRIKE);
        this.count = count;
    }

    @Override
    public String getText() {
        if (count == ZERO) {
            return EMPTY;
        }
        return this.rule.getText(count);
    }
}
