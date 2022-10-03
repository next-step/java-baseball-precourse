package baseball.domain.input.factory;

import baseball.domain.input.Input;
import baseball.domain.number.PlayerNumber;

public class InputPlayerNumberFactory implements InputFactory<PlayerNumber> {

    private final Input<PlayerNumber> input;

    public InputPlayerNumberFactory(Input<PlayerNumber> input) {
        this.input = input;
    }

    @Override
    public PlayerNumber create() {
        this.input.validate();
        return this.input.create();
    }
}
