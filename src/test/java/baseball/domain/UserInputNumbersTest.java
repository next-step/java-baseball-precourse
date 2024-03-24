package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputNumbersTest {
    @Test
    @DisplayName("3자리의 올바른 범위의 숫자라면, 올바른 유저 게임 숫자가 생성된다.")
    void create_success_if_correct_user_numbers() {
        var input = "123";

        assertDoesNotThrow(() -> UserInputNumbers.from(input));
    }

    @Test
    @DisplayName("숫자가 아닌 입력이 존재한다면, 예외를 던진다.")
    void create_fail_if_not_number_in_input() {
        var input = "a12";

        assertThrows(Exception.class, () -> UserInputNumbers.from(input));
    }

    @Test
    @DisplayName("입력된 값의 길이가 3이 아니라면, 예외를 던진다.")
    void create_fail_if_input_length_is_not_3() {
        var input = " ";

        assertThrows(Exception.class, () -> UserInputNumbers.from(input));
    }

    @Test
    @DisplayName("입력 숫자에 중복이 존재하면, 예외를 던진다.")
    void create_fail_if_answer_numbers_has_duplication() {
        var input = "112";

        assertThrows(Exception.class, () -> UserInputNumbers.from(input));
    }
}
