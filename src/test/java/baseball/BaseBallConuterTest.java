package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseBallConuterTest {
    @Test
    void can_create() {
        BaseballGeneratorStub baseballGeneratorStub = new BaseballGeneratorStub(Arrays.asList(1, 2, 3));
        BaseballCounter baseBallConuter = new BaseballCounter(baseballGeneratorStub);
    }

    @Test
    void user_input_invalid_test() {
        BaseballGeneratorStub baseballGeneratorStub = new BaseballGeneratorStub(Arrays.asList(1, 2, 3));
        BaseballCounter baseBallConuter = new BaseballCounter(baseballGeneratorStub);

        assertThatThrownBy(() -> baseBallConuter.isValid(Arrays.asList(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의");
    }

    @Test
    void is_nothing() {
        BaseballGeneratorStub baseballGeneratorStub = new BaseballGeneratorStub(Arrays.asList(1, 2, 3));
        BaseballCounter baseBallConuter = new BaseballCounter(baseballGeneratorStub);
        baseBallConuter.isValid(Arrays.asList(4, 5, 6));

        int actual = baseBallConuter.getBallCount(Arrays.asList(4, 5, 6));
        assertThat(actual).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"123, 561, 1", "123, 237, 2"})
    void ball_count_test(String answer, String guess, int ball) {
        BaseballGeneratorStub baseballGeneratorStub = new BaseballGeneratorStub(Utils.stringToTntArray(answer));
        BaseballCounter baseBallCounter = new BaseballCounter(baseballGeneratorStub);
        baseBallCounter.isValid(Utils.stringToTntArray(guess));

        int actual = baseBallCounter.getBallCount(Utils.stringToTntArray(guess));
        assertThat(actual).isEqualTo(ball);
    }

    @ParameterizedTest
    @CsvSource({"123, 145, 1", "123, 124, 2", "123, 123, 3"})
    void strike_count_test(String answer, String guess, int strike) {
        BaseballGeneratorStub baseballGeneratorStub = new BaseballGeneratorStub(Utils.stringToTntArray(answer));
        BaseballCounter baseBallCounter = new BaseballCounter(baseballGeneratorStub);
        baseBallCounter.isValid(Utils.stringToTntArray(guess));

        int actual = baseBallCounter.getStrikeCount(Utils.stringToTntArray(guess));
        assertThat(actual).isEqualTo(strike);
    }
}
