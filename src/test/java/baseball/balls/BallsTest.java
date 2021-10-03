package baseball.balls;


import baseball.balls.exceptions.BallsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    private List<Ball> ballList;

    @Test
    @DisplayName("세개의 공을 가지고 있는 Balls 생성")
    public void createBalls() {
        Ball firstBall = new Ball(1, 2);
        Ball secondBall = new Ball(2, 4);
        Ball thirdBall = new Ball(3, 6);

        ballList = Arrays.asList(firstBall, secondBall, thirdBall);

        Balls balls = new Balls(ballList);

        assertThat(balls.getBallList().get(0).getNumber()).isEqualTo(2);
        assertThat(balls.getBallList().get(1).getNumber()).isEqualTo(4);
        assertThat(balls.getBallList().get(2).getNumber()).isEqualTo(6);
    }


    @Test
    @DisplayName("중복된 숫자 발생 시 에러 발생")
    public void ballsDuplicatedException(){
        assertThatThrownBy(()->{
            Ball firstBall = new Ball(1, 2);
            Ball secondBall = new Ball(2, 4);
            Ball thirdBall = new Ball(3, 4);

            ballList = Arrays.asList(firstBall, secondBall, thirdBall);

            Balls balls = new Balls(ballList);
        }).isInstanceOf(BallsException.class)
                .hasMessage("중복된 숫자는 입력할 수 없습니다.");

    }



}
