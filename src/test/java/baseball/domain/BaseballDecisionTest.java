package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballDecisionTest {
    private static final int START_RANDOM_NUMBER = 1;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    private final BaseballNumberValidator validator = new BaseballNumberValidator(START_RANDOM_NUMBER,
                                                                                  END_RANDOM_NUMBER,
                                                                                  NUMBER_COUNT);

    private final BaseballNumber computerNumber = new BaseballNumber(validator);
    private final BaseballNumber userNumber = new BaseballNumber(validator);
    private final BaseballDecision decision = new BaseballDecision();

    @BeforeEach
    void setUp() {
        computerNumber.setNumbers(Arrays.asList(4, 2, 5));
        decision.setComputerNumber(computerNumber);
    }

    @Test
    @DisplayName("결과 1스트라이크")
    void threeStrike() {
        // given
        userNumber.setNumbers(Arrays.asList(1, 2, 3));

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("결과 1볼 1스트라이크")
    void oneBallOneStrike() {
        // given
        userNumber.setNumbers(Arrays.asList(4, 5, 6));

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("결과 낫싱")
    void nothing() {
        // given
        userNumber.setNumbers(Arrays.asList(7, 8, 9));

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("낫싱");
    }
}
