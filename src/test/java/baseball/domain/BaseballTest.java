package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.result.BallResult;
import baseball.domain.result.DefaultResult;
import baseball.domain.result.Result;
import baseball.domain.result.State;
import baseball.domain.result.StrikeResult;
import baseball.domain.rule.BallRule;
import baseball.domain.rule.Rule;
import baseball.domain.rule.StrikeRule;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {

    private static final String NOTHING = State.NOTHING.getDescription();
    private static final String STRIKE = State.STRIKE.getDescription();
    private static final String BALL = State.BALL.getDescription();

    Baseball baseball;
    Result result;

    @BeforeEach
    void beforeEach() {
        result = new DefaultResult();
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        baseball = new Baseball(result, "123");
        assertThat(baseball.result()).isEqualTo(NOTHING);
    }

    @ParameterizedTest
    @DisplayName("1,2,3 스트라이크")
    @ValueSource(ints = {1, 2, 3})
    void strike(int strike) {
        result = new StrikeResult(result);
        result.setStrike(strike);
        baseball = new Baseball(result, "123");
        assertThat(baseball.result()).isEqualTo(strike + STRIKE);
    }

    @ParameterizedTest
    @DisplayName("1,2,3 볼")
    @ValueSource(ints = {1, 2, 3})
    void ball(int ball) {
        result = new BallResult(result);
        result.setBall(ball);
        baseball = new Baseball(result, "123");
        assertThat(baseball.result()).isEqualTo(ball + BALL);
    }

    @ParameterizedTest
    @DisplayName("볼_스트라이크")
    @CsvSource(value = {"1:1", "2:1", "1:2"}, delimiter = ':')
    void ball(int ball, int strike) {
        result = new BallResult(new StrikeResult(result));
        result.setBall(ball);
        result.setStrike(strike);
        baseball = new Baseball(result, "123");
        assertThat(baseball.result()).isEqualTo(ball + BALL + " " + strike + STRIKE);
    }

    @ParameterizedTest
    @DisplayName("플레이 테스트")
    @CsvSource(value = {
            "123:3스트라이크", "312:3볼", "456:낫싱", "132:2볼 1스트라이크"
    }, delimiter = ':')
    void play(String input, String gameResult) {
        result = new BallResult(new StrikeResult(result));
        baseball = new Baseball(result, "123");
        List<Rule> rules = Arrays.asList(new BallRule(), new StrikeRule());
        for (Rule rule : rules) {
            baseball.play(rule, input);
        }
        assertThat(baseball.result()).isEqualTo(gameResult);
    }
}
