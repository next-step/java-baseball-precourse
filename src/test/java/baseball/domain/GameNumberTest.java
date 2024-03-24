package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GameNumber")
class GameNumberTest {

    @Test
    @DisplayName("올바른 게임 번호가 주어졌을 때, 정상적으로 생성된다.")
    void create_success_game_number() {
        var number = 1;

        assertDoesNotThrow(() -> GameNumber.create(number));
    }

    @Test
    @DisplayName("범위에 벗어난 게임 번호가 주어졌을 때, 예외를 던진다.")
    void create_fail_game_number() {
        var number = 0;

        assertThrows(IllegalArgumentException.class, () -> GameNumber.create(number));
    }

    @Test
    @DisplayName("두 게임 숫자가 같다면 true를 반환한다.")
    void return_true_if_same_game_number() {
        var number1 = GameNumber.create(1);
        var number2 = GameNumber.create(1);

        assertEquals(number1, number2);
    }

    @Test
    @DisplayName("두 게임 숫자가 다르면 false를 반환한다.")
    void return_false_if_different_game_number() {
        var number1 = GameNumber.create(1);
        var number2 = GameNumber.create(2);

        assertNotEquals(number1, number2);
    }
}