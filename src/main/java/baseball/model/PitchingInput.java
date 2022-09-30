package baseball.model;

public class PitchingInput {
    private final Integer number;
    private final Integer order;

    public PitchingInput(Integer number, Integer order) {
        GameDataValidator.validateOrder(order);
        GameDataValidator.validateNumber(number);
        this.number = number;
        this.order = order;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getOrder() {
        return order;
    }
}
