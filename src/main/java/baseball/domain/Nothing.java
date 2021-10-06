package baseball.domain;

public class Nothing {

    private final Rule rule;

    public Nothing() {
        this.rule = Rule.NOTHING;
    }

    public String getText() {
        return rule.getName();
    }
}
