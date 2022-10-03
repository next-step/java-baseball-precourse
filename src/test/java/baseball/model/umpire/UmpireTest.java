package baseball.model.umpire;

import static baseball.constant.BaseballStringEnum.ONE_STRIKE;
import static baseball.constant.BaseballStringEnum.THREE_BALL;
import static baseball.constant.BaseballStringEnum.THREE_STRIKE;
import static baseball.constant.BaseballStringEnum.TWO_BALL;
import static baseball.constant.BaseballStringEnum.ZERO_BALL;
import static baseball.constant.BaseballStringEnum.ZERO_STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UmpireTest {

    @Test
    void judge_three_strike() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "123")).startsWith(ZERO_BALL.label).contains(THREE_STRIKE.label);
    }

    @Test
    void judge_three_ball() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "312")).startsWith(THREE_BALL.label).contains(ZERO_STRIKE.label);
    }

    @Test
    void judge_two_ball_one_strike() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "213")).startsWith(TWO_BALL.label).contains(ONE_STRIKE.label);
    }

    @Test
    void judge_nothing() {
        Umpire unit = new Umpire();
        assertThat(unit.judge("123", "456")).startsWith(ZERO_BALL.label).endsWith(ZERO_STRIKE.label);
    }

    @Test
    void isABall() {
        Umpire unit = new Umpire();
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            ball += unit.isABall("123", "256", i);
        }
        assertThat(ball).isEqualTo(1);
    }

    @Test
    void isAStrike() {
        Umpire unit = new Umpire();
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            strike += unit.isAStrike("123", "423", i);
        }
        assertThat(strike).isEqualTo(2);
    }
}