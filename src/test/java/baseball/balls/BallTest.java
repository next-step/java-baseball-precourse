package baseball.balls;

import baseball.balls.exceptions.BallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("공의 숫자와 위치 범위가 벗어날 경우 에러 발생")
    public void ballRangeException(){
        assertThatThrownBy(()->{
            Ball wrongPositionBall = new Ball(4,9);
        }).isInstanceOf(BallException.class)
                .hasMessage("위치의 범위는 1이상 3이하이여야 합니다.");

        assertThatThrownBy(()->{
            Ball wrongNumberBall = new Ball(2,14);
        }).isInstanceOf(BallException.class)
                .hasMessage("숫자의 범위는 1이상 9이하이여야 합니다.");

    }



}
