package baseball.model;

public class PitchingInput {
    private final Integer number;
    private final Integer order;

    public PitchingInput(Integer number, Integer order) {
        validateOrder(order);
        this.number = number;
        this.order = order;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getOrder() {
        return order;
    }

    /*
        Todo: Validator 분리
     */
    private void validateOrder(int order) {
        if (order < 0) {
            throw new IllegalArgumentException();
        }

        if (BaseballGameRule.PITCHING_COUNT < order) {
            throw new IllegalArgumentException();
        }
    }
}
