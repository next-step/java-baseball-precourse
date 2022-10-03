package baseball.domain.input.factory;

import baseball.domain.input.Input;
import baseball.type.GameOverType;

public class InputGameOverFactory implements InputFactory<GameOverType> {

    private final Input<GameOverType> input;

    public InputGameOverFactory(Input<GameOverType> input) {
        this.input = input;
    }

    @Override
    public GameOverType create() {
        this.input.validate();
        return this.input.create();
    }
}
