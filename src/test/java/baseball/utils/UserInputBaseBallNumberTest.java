package baseball.utils;

import baseball.Constants.ErrorMessage;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class UserInputBaseBallNumberTest {

    @Test
    void 사용자입력값테스트_세자리수_정상케이스(){
        new UserInputBaseBallNumberValidator("123").isValidValue();
        new UserInputBaseBallNumberValidator("987").isValidValue();
    }

    @Test
    void 사용자입력값테스트_세자리수_길이오류(){
        assertThatThrownBy(
                () -> {
                    new UserInputBaseBallNumberValidator("1234").isValidValue();
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching(ErrorMessage.WRONG_LENGTH_MESSAGE);
    }

    @Test
    void 사용자입력값테스트_세자리수_범위오류(){
        assertThatThrownBy(
                () -> {
                    new UserInputBaseBallNumberValidator("012").isValidValue();
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching(ErrorMessage.WRONG_NUMBER_MESSAGE);

    }

    @Test
    void 사용자입력값테스트_세자리수_중복오류(){
        assertThatThrownBy(
                () -> {
                    new UserInputBaseBallNumberValidator("122").isValidValue();
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching(ErrorMessage.WRONG_UNIQUE_MESSAGE);
    }

}