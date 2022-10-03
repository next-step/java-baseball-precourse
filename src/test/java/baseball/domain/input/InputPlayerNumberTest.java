package baseball.domain.input;

import static baseball.type.ErrorMessageType.INPUT_ALLOW_JUST_3_DIGIT_NUMBERS;
import static baseball.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;
import static baseball.type.ErrorMessageType.INPUT_NOT_ALLOW_DUPLICATE;
import static baseball.type.ErrorMessageType.INPUT_ONLY_ALLOW_NUMBER;
import static baseball.type.ErrorMessageType.LESS_THAN_START_INCLUSIVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.domain.input.factory.InputPlayerNumberFactory;
import baseball.domain.number.PlayerNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputPlayerNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"014", "104", "140"})
    @DisplayName("시작 범위의 수보다 입력한 수가 작으면 IllegalArgumentException 예외가 발생한다.")
    void inputPlayerNumber_notAllowLessThanStartInclusive(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                Input<PlayerNumber> inputPlayerNumber = new InputPlayerNumber(input);
                inputPlayerNumber.validate();
            })
            .withMessageContaining(LESS_THAN_START_INCLUSIVE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("사용자가 입력한 값에 공백이 있는 경우 IllegalArgumentException 예외가 발생한다.")
    void inputPlayerNumber_notAllowNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                Input<PlayerNumber> inputPlayerNumber = new InputPlayerNumber(input);
                inputPlayerNumber.validate();
            })
            .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    @DisplayName("사용자가 입력한 값이 3자리가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    void inputPlayerNumber_allowJust3_digitNumbers(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                Input<PlayerNumber> inputPlayerNumber = new InputPlayerNumber(input);
                inputPlayerNumber.validate();
            })
            .withMessageContaining(INPUT_ALLOW_JUST_3_DIGIT_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1e3", "!@#"})
    @DisplayName("사용자가 입력한 값이 숫자가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    void inputPlayerNumber_allowOnlyNumber(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                Input<PlayerNumber> inputPlayerNumber = new InputPlayerNumber(input);
                inputPlayerNumber.validate();
            })
            .withMessageContaining(INPUT_ONLY_ALLOW_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사용자가 입력한 값에 중복된 숫자가 존재하는 경우 IllegalArgumentException 예외가 발생한다.")
    void inputPlayerNumber_notAllowDuplicate() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> {
                Input<PlayerNumber> inputPlayerNumber = new InputPlayerNumber("111");
                inputPlayerNumber.validate();
            })
            .withMessageContaining(INPUT_NOT_ALLOW_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("입력한 숫자가 정상이면 PlayerNumber가 생성된다.")
    void inputPlayerNumber_createSuccess() {
        PlayerNumber playerNumber = new InputPlayerNumberFactory(
            new InputPlayerNumber("479")
        ).create();
        List<Integer> playerNumbers = playerNumber.toList();
        assertThat(playerNumbers).containsExactly(4, 7, 9);
    }
}