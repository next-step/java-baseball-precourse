import static org.assertj.core.api.Assertions.*;

import domain.baseball.BaseballGame;
import domain.baseball.Hint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputValidator;

public class BaseballGameTest {
    private BaseballGame baseballGame;
    private InputValidator inputValidator;

    @BeforeEach
    void init() {
        baseballGame = new BaseballGame();
        inputValidator = new InputValidator();
        baseballGame.initComputerNumber();
    }

    @ParameterizedTest
    @ValueSource(ints = {123, 345, 521})
    void 유효한_숫자_true(int number) {
        assertThat(inputValidator.isValidNumber(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 1, 111, 3214})
    void 유효한_숫자_false(int number) {
        assertThat(inputValidator.isValidNumber(number)).isFalse();
    }

    @Test
    void 스트라이크3_테스트() {
        for (int i = 0; i < 10; i++) {
            int number = baseballGame.getComputerNumber();
            Hint hint = baseballGame.updateHint(number);
            assertThat(hint.isThreeStrike()).isTrue();
        }
    }

    @ParameterizedTest
    @CsvSource({"321,142", "567,751"})
    void 볼2_테스트(int computerNumber, int userNumber) {
        baseballGame.setComputerNumber(computerNumber);
        Hint hint = baseballGame.updateHint(userNumber);
        assertThat(hint.getStrike() == 0 && hint.getBall() == 2).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"132,321", "456,564"})
    void 볼3_테스트(int computerNumber, int userNumber) {
        baseballGame.setComputerNumber(computerNumber);
        Hint hint = baseballGame.updateHint(userNumber);
        assertThat(hint.getStrike() == 0 && hint.getBall() == 3).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"123,456"})
    void 낫싱_테스트(int computerNumber, int userNumber) {
        baseballGame.setComputerNumber(computerNumber);
        Hint hint = baseballGame.updateHint(userNumber);
        assertThat(hint.isNothing()).isTrue();
    }
}