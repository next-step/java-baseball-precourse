package baseball.domain;

import baseball.io.BaseballInput;
import baseball.util.NumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballResultTest {
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

    @ParameterizedTest(name = "{displayName} value={0}")
    @ValueSource(strings = "123")
    @DisplayName("결과 1스트라이크")
    void oneStrike(String value) {
        // given
//        BaseballInput input = new ConsoleBaseballInput(); // 콘솔 입력을 받을 수 없다.
        BaseballInput input = new MockBaseballInput(value); // 인자로 전달된 값을 반환하는 목 객체 사용
        String text = input.read();
        List<Integer> numbers = NumberUtil.convertStringToIntegerList(text);
        BaseballNumber userNumber = new BaseballNumber(numbers, validator);

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1스트라이크");
    }

    @ParameterizedTest(name = "{displayName} value={0}")
    @ValueSource(strings = "456")
    @DisplayName("결과 1볼 1스트라이크")
    void oneBallOneStrike(String value) {
        // given
        BaseballInput input = new MockBaseballInput(value);
        String text = input.read();
        List<Integer> numbers = NumberUtil.convertStringToIntegerList(text);
        BaseballNumber userNumber = new BaseballNumber(numbers, validator);

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("1볼 1스트라이크");
    }

    @ParameterizedTest(name = "{displayName} value={0}")
    @ValueSource(strings = "789")
    @DisplayName("결과 낫싱")
    void nothing(String value) {
        // given
        BaseballInput input = new MockBaseballInput(value);
        String text = input.read();
        List<Integer> numbers = NumberUtil.convertStringToIntegerList(text);
        BaseballNumber userNumber = new BaseballNumber(numbers, validator);

        // when
        BaseballResult result = decision.getResult(userNumber);

        // then
        assertThat(result.getMessage()).isEqualTo("낫싱");
    }

    static class MockBaseballInput implements BaseballInput {
        private final String text;

        public MockBaseballInput(String text) {
            this.text = text;
        }

        @Override
        public String read() {
            return text;
        }
    }
}
