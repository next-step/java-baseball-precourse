package baseball.domain.result;

public class DefaultResult extends Result {
    @Override
    public String result() {
        return State.NOTHING.getDescription();
    }
}
