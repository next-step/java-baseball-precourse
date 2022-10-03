package baseball.domain.input;

import static baseball.type.GameOverType.getGameOverTypeByInput;
import static baseball.type.GameOverType.isGameOverType;

import baseball.type.GameOverType;

public class InputGameOver implements Input<GameOverType> {

    private final String input;

    public InputGameOver(String input) {
        this.input = input;
    }

    @Override
    public void validate() {
        validateBlank(this.input);
        validateGameOverType(this.input);
    }

    @Override
    public GameOverType create() {
        return getGameOverTypeByInput(this.input);
    }

    private void validateGameOverType(String input) {
        isGameOverType(input);
    }
}
