package baseball.domain;

import baseball.constant.BaseballConfig;
import baseball.constant.BaseballMessages;
import baseball.constant.BaseballRestartStatus;
import baseball.domain.decision.ResultDecision;
import baseball.domain.generator.NumberGenerator;
import baseball.domain.validator.DefaultNumberValidator;
import baseball.domain.validator.NumberValidator;
import baseball.io.BaseballInput;
import baseball.io.BaseballOutput;
import baseball.io.ConsoleBaseballOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballGameTest {
    private static final int START_RANDOM_NUMBER = BaseballConfig.START_RANDOM_NUMBER;
    private static final int END_RANDOM_NUMBER = BaseballConfig.END_RANDOM_NUMBER;
    private static final int NUMBER_COUNT = BaseballConfig.NUMBER_COUNT;

    private final BaseballNumberConfig config = new BaseballNumberConfig(START_RANDOM_NUMBER, END_RANDOM_NUMBER,
                                                                         NUMBER_COUNT);

    @Test
    @DisplayName("1회 정답 후 게임 종료")
    void success1() {
        // given
        NumberGenerator numberGenerator = new TestNumberGenerator();
        NumberValidator numberValidator = new DefaultNumberValidator(config);
        ResultDecision resultDecision = new TestResultDecision();

        BaseballInput input = new BaseballInput() {
            private final Queue<String> inputQueue = new LinkedList<>(
                    Arrays.asList("123", BaseballRestartStatus.N.getValue()));
            @Override
            public String read() {
                return inputQueue.poll();
            }
        };
        BaseballOutput output = new ConsoleBaseballOutput(System.out);

        BaseballGame baseballGame = new BaseballGame(config, numberGenerator, numberValidator, resultDecision,
                                                     input, output);

        // when
        Boolean validation = assertDoesNotThrow(() -> {
            baseballGame.start();
            return true;
        });

        // then
        assertThat(validation).isEqualTo(Boolean.TRUE);
    }

    @Test
    @DisplayName("3회 정답 후 게임 종료")
    void success3() {
        // given
        NumberGenerator numberGenerator = new TestNumberGenerator();
        NumberValidator numberValidator = new DefaultNumberValidator(config);
        ResultDecision resultDecision = new TestResultDecision();

        BaseballInput input = new BaseballInput() {
            private final Queue<String> inputQueue = new LinkedList<>(
                    Arrays.asList(
                            "123", BaseballRestartStatus.Y.getValue(),
                            "123", BaseballRestartStatus.Y.getValue(),
                            "123", BaseballRestartStatus.N.getValue()));
            @Override
            public String read() {
                return inputQueue.poll();
            }
        };
        BaseballOutput output = new ConsoleBaseballOutput(System.out);

        BaseballGame baseballGame = new BaseballGame(config, numberGenerator, numberValidator, resultDecision,
                                                     input, output);

        // when
        Boolean validation = assertDoesNotThrow(() -> {
            baseballGame.start();
            return true;
        });

        // then
        assertThat(validation).isEqualTo(Boolean.TRUE);
    }

    @Test
    @DisplayName("입력 값 오류로 예외 발생")
    void validate() {
        // given
        NumberGenerator numberGenerator = new TestNumberGenerator();
        NumberValidator numberValidator = new DefaultNumberValidator(config);
        ResultDecision resultDecision = new TestResultDecision();

        BaseballInput input = () -> "1234";
        BaseballOutput output = new ConsoleBaseballOutput(System.out);

        BaseballGame baseballGame = new BaseballGame(config, numberGenerator, numberValidator, resultDecision,
                                                     input, output);

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class,
                                           baseballGame::start);
        String message = exception.getMessage();

        // then
        assertThat(message).isEqualTo(String.format(BaseballMessages.ERROR_NUMBER_COUNT, NUMBER_COUNT));
    }

    static class TestNumberGenerator implements NumberGenerator {
        @Override
        public List<Integer> generateNumbers() {
            return Arrays.asList(1, 2, 3);
        }
    }

    static class TestResultDecision implements ResultDecision {
        @Override
        public BaseballResult decide(BaseballNumber computerNumber, BaseballNumber userNumber) {
            return new BaseballResult(NUMBER_COUNT, 0);
        }
    }
}
