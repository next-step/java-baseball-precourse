package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final User user = new User();

    @DisplayName("3자리의 숫자를 입력한다면, 볼카운트가 정상 기록된다.")
    @Test
    void throwBallsSuccess() {
        // given
        String input = "123";

        // when
        user.throwBalls(input);
        List<Integer> ballCount = user.getBallCount();

        // then
        assertTrue(ballCount.size() == 3);
    }

    @DisplayName("3자리의 초과하는 숫자를 입력한다면, 예외처리가 발생한다.")
    @Test
    void checkBallCountInLength() {
        // given
        String input = "1234";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> user.throwBalls(input));
    }

    @DisplayName("숫자가 아닌 문자가 포함될 경우, 예외처리가 발생한다.")
    @Test
    void checkBallCountWithoutDigit() {
        // given
        String input = "a89";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> user.throwBalls(input));
    }

    @DisplayName("0이 포함된 숫자조합에서는, 예외처리가 발생한다.")
    @Test
    void checkBallCountWithZero() {
        // given
        String input = "012";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> user.throwBalls(input));
    }

    @DisplayName("중복된 숫자조합에서는, 예외처리가 발생한다.")
    @Test
    void checkBallCountDuplication() {
        // given
        String input = "112";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> user.throwBalls(input));
    }
}