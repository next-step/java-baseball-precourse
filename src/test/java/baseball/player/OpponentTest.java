package baseball.player;

import baseball.ball.Ball;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OpponentTest {

    @Test
    @DisplayName(value = "opponent 생성 시 올바른 Ball 객체 생성 확인")
    void opponent_create_ball_test() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        Ball ball = new Ball(randomNumber);
        Opponent opponent = new Opponent();
        Ball opponentBall = opponent.createBall(randomNumber);
        assertThat(ball).isEqualTo(opponentBall);
    }

}
