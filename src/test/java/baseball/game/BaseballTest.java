package baseball.game;


import static baseball.constant.BaseballStringEnum.ONE_BALL;
import static baseball.constant.BaseballStringEnum.ONE_STRIKE;
import static baseball.constant.BaseballStringEnum.STRIKE_IN_KOREAN;
import static baseball.constant.BaseballStringEnum.THREE_STRIKE;
import static baseball.constant.BaseballStringEnum.TWO_STRIKE;
import static baseball.constant.BaseballStringEnum.ZERO_BALL;
import static baseball.constant.BaseballStringEnum.ZERO_STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BaseballTest {

    @Mock
    AutoCloseable closeable;
    @InjectMocks
    Baseball unit;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void after() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("when user gets one ball and two strikes")
    void displayResult_() {
        assertThat(unit.returnStringifiedJudgeStatement(ONE_BALL.label, TWO_STRIKE.label))
                .contains(String.format("%s", ONE_BALL.label))
                .contains(String.format("%s%s", TWO_STRIKE.label, STRIKE_IN_KOREAN.label));

    }

    @Test
    @DisplayName("game should be finished if user gets three strikes")
    void needToFinish() {
        assertThat(unit.checkIfGameIsDone(Arrays.asList(ZERO_BALL.label, THREE_STRIKE.label))).isTrue();
    }

    @Test
    void isaZeroStrike() {
        assertThat(unit.isaZeroStrike(ZERO_STRIKE.label)).isTrue();
    }

    @Test
    void isaZeroStrike_fail() {
        assertThat(unit.isaZeroStrike(ONE_STRIKE.label)).isFalse();
    }

    @Test
    void isaZeroBall() {
        assertThat(unit.isaZeroBall(ZERO_BALL.label)).isTrue();
    }

    @Test
    void isaZeroBall_fail() {
        assertThat(unit.isaZeroBall(ONE_BALL.label)).isFalse();
    }

    @Test
    void isaNothing() {
        assertThat(unit.isaNothing(ZERO_BALL.label, ZERO_STRIKE.label)).isTrue();
    }

    @Test
    void isaNothing_fail_ball() {
        assertThat(unit.isaNothing(ONE_BALL.label, ZERO_STRIKE.label)).isFalse();
    }

    @Test
    void isaNothing_fail_on_strike() {
        assertThat(unit.isaNothing(ZERO_BALL.label, ONE_STRIKE.label)).isFalse();
    }
}