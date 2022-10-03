package baseball;

import baseball.ball.Ball;
import baseball.player.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName(value = "user 생성 시 올바른 Ball 객체 생성 확인")
    void user_create_ball_test(int ballNumber) {
        String inputNumber = "123";
        User user = new User();
        Ball ball = user.createBall(inputNumber);
        List<Integer> ballNumbers = ball.getBallNumbers();
        assertThat(ballNumbers.contains(ballNumber)).isTrue();
    }
}
