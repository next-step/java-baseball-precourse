package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("01_컴퓨터 랜덤 볼 확인")
    void random_ball_check() {
        BallList computerBallList = new Computer();
        assertThat(computerBallList.ballList.size()).isEqualTo(3);
    }

}