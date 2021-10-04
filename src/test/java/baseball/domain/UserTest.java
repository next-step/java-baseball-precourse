package baseball.domain;

import baseball.constant.Const;
import baseball.exception.InvalidUserInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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

    @Test
    @DisplayName("숫자 유형이 아닌 값 리스트 삽입 테스트")
    void input_user_not_number_type_test() {
        String receiveUserInput = "4ab";
        assertThatThrownBy(() -> user.initNumber(receiveUserInput))
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining("유효하지 않은 문자");
    }

    @Test
    @DisplayName("입력제한 길이보다 크게 입력된 경우 테스트")
    void input_larger_than_input_limit_length_test() {
        String receiveUserInput = "51382";
        assertThatThrownBy(() -> user.initNumber(receiveUserInput))
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining(Const.GENERATE_NUMBER_SIZE + "개의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("입력제한 길이보다 작게 입력된 경우 테스트")
    void input_smaller_than_input_limit_length_test() {
        String receiveUserInput = "82";
        assertThatThrownBy(() -> user.initNumber(receiveUserInput))
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining(Const.GENERATE_NUMBER_SIZE + "개의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("중복된 숫자를 입력했을 경우 테스트")
    void input_duplicate_number_test() {
        String receiveUserInput = "882";
        assertThatThrownBy(() -> user.initNumber(receiveUserInput))
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining("중복된 숫자를 입력하였습니다.");
    }

}
