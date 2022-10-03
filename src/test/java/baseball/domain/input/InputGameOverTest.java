package baseball.domain.input;

import static baseball.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;
import static baseball.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.input.factory.InputGameOverFactory;
import baseball.type.GameOverType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputGameOverTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("사용자가 입력한 값에 공백이 있는 경우 IllegalArgumentException 예외가 발생한다.")
    void inputPlayerNumber_notAllowNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                Input<GameOverType> inputGameOver = new InputGameOver(input);
                inputGameOver.validate();
            })
            .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"t", "+", "0"})
    @DisplayName("게임 종료 여부를 입력할 때 사용자가 입력한 값이 1, 2가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    void inputGameOver_allowOneOrTwoStrings(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                Input<GameOverType> inputGameOver = new InputGameOver(input);
                inputGameOver.validate();
            })
            .withMessageContaining(INPUT_ONLY_ALLOW_NUMBER.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1:RESTART", "2:FINISH"}, delimiter = ':')
    @DisplayName("입력한 값이 1이면 RESTART, 2이면 FINISH 를 리턴한다.")
    void inputGameOver_success(String input, String expected) {
        GameOverType gameOverType = new InputGameOverFactory(
            new InputGameOver(input)
        ).create();
        assertEquals(expected, gameOverType.name());
    }
}