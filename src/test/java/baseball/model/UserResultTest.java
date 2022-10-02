package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserResultTest {

    @Test
    @DisplayName("01_3스트라이크 확인")
    void result_success() {
        BallList ballList = new BallList();
        ballList.addBall(Arrays.asList(1, 2, 3));
        User user = new User("123");
        user.score(ballList.ballList);
        Assertions.assertThat(user.userResult.getResult()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("02_2볼 1스트라이크 확인")
    void one_strike_two_ball() {
        BallList ballList = new BallList();
        ballList.addBall(Arrays.asList(1, 2, 3));
        User user = new User("132");
        user.score(ballList.ballList);
        Assertions.assertThat(user.userResult.getResult()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("03_3볼 확인")
    void three_ball() {
        BallList ballList = new BallList();
        ballList.addBall(Arrays.asList(3, 2, 1));
        User user = new User("132");
        user.score(ballList.ballList);
        Assertions.assertThat(user.userResult.getResult()).isEqualTo("3볼");
    }
}