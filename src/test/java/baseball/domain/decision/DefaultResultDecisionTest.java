package baseball.domain.decision;

import baseball.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultResultDecisionTest {
    private BaseballNumber computerNumber;
    private final ResultDecision resultDecision = new DefaultResultDecision();

    @BeforeEach
    void setUp() {
        List<Integer> numbers = Arrays.asList(4, 2, 5);
        computerNumber = new BaseballNumber(numbers);
    }

    @Test
    @DisplayName("결과 1스트라이크")
    void oneStrike() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        BaseballNumber userNumber = new BaseballNumber(numbers);

        // when
        BaseballResult result = resultDecision.decide(computerNumber, userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("결과 1볼 1스트라이크")
    void oneBallOneStrike() {
        // given
        List<Integer> numbers = Arrays.asList(4, 5, 6);
        BaseballNumber userNumber = new BaseballNumber(numbers);

        // when
        BaseballResult result = resultDecision.decide(computerNumber, userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("결과 낫싱")
    void nothing() {
        // given
        List<Integer> numbers = Arrays.asList(7, 8, 9);
        BaseballNumber userNumber = new BaseballNumber(numbers);

        // when
        BaseballResult result = resultDecision.decide(computerNumber, userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("낫싱");
    }
}
