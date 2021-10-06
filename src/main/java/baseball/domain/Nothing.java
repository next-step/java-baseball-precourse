package baseball.domain;

public class Nothing extends GameRule {

    public Nothing() {
        super(Rule.NOTHING);
    }

    @Override
    public String getText() {
        return rule.getName();
    }
}
