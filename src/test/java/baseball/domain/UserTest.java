package baseball.domain;

import baseball.exception.InvalidUserInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("리스트 삽입 테스트")
    void input_user_number_test() {
        String receiveUserInput = "413";
        user.initNumber(receiveUserInput);
        assertThat(user.getNumbers().size()).isEqualTo(3);
        assertThat(user.getNumbers()).containsExactly(4, 1, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4ab:유효하지 않은 문자",
            "51382:3개의 숫자를 입력해주세요",
            "82:3개의 숫자를 입력해주세요",
            "882:중복된 숫자를 입력하였습니다."
    }, delimiter = ':')
    @DisplayName("유효하지 않은 사용자 입력 리스트 삽입 테스트")
    void invalid_input_test(String receiveUserInput, String errorMessage) {
        assertThatThrownBy(() -> user.initNumber(receiveUserInput))
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "--", "__", "```", "exit"})
    @DisplayName("게임 종료를 위해 숫자가 아닌 유형의 값을 입력했을 경우")
    void invalid_input_game_over_test(String input) {
        assertThatThrownBy(() -> user.isGameStop(input))
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining("유효하지 않은 문자");
    }

}
