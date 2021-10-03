package baseball.balls;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    @DisplayName("위치정보와 숫자를 가진 공 생성")
    public void createBall(){
        Ball firstBall = new Ball(1,3);
        Ball secondBall = new Ball(2,8);
        Ball thirdBall = new Ball(3,2);

        assertThat(firstBall.getPosition()).isEqualTo(1);
        assertThat(secondBall.getPosition()).isEqualTo(2);
        assertThat(thirdBall.getPosition()).isEqualTo(3);

        assertThat(firstBall.getNumber()).isEqualTo(3);
        assertThat(secondBall.getNumber()).isEqualTo(8);
        assertThat(thirdBall.getNumber()).isEqualTo(2);
    }


}
