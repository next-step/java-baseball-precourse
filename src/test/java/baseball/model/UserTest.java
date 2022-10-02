package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private final User user = new User();

    @DisplayName("3자리의 숫자를 입력한다면, 볼카운트가 정상 기록된다.")
    @Test
    void throwBallsSuccess() {
        // given
        String input = "123";

        // when
        user.throwBalls(input);
        List<String> ballCount = user.getBallCount();

        // then
        assertTrue(ballCount.size() == 3);
    }
}