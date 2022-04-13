package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballDecisionTest {
    private static final int START_RANDOM_NUMBER = 1;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    private final BaseballNumberValidator validator = new BaseballNumberValidator(START_RANDOM_NUMBER,
                                                                                  END_RANDOM_NUMBER,
                                                                                  NUMBER_COUNT);

    private BaseballDecision decision;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = Arrays.asList(4, 2, 5);
        BaseballNumber computerNumber = new BaseballNumber(numbers, validator);
        decision = new BaseballDecision(computerNumber);
    }

    @Test
    @DisplayName("결과 1스트라이크")
    void oneStrike() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        BaseballNumber userNumber = new BaseballNumber(numbers, validator);

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("결과 1볼 1스트라이크")
    void oneBallOneStrike() {
        // given
        List<Integer> numbers = Arrays.asList(4, 5, 6);
        BaseballNumber userNumber = new BaseballNumber(numbers, validator);

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("결과 낫싱")
    void nothing() {
        // given
        List<Integer> numbers = Arrays.asList(7, 8, 9);
        BaseballNumber userNumber = new BaseballNumber(numbers, validator);

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("낫싱");
    }
}
