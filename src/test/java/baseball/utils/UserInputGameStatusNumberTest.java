package baseball.utils;

import baseball.Constants.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputGameStatusNumberTest {

    @Test
    void 사용자입력값테스트_게임재시작혹은종료_정상케이스(){
        new UserInputGameStatusNumberValidator("1").isValidValue();
        new UserInputGameStatusNumberValidator("2").isValidValue();
    }

    @Test
    void 사용자입력값테스트_게임재시작혹은종료_길이오류(){
        assertThatThrownBy(
                () -> {
                    new UserInputGameStatusNumberValidator("11").isValidValue();
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching(ErrorMessage.WRONG_LENGTH_MESSAGE);
    }

    @Test
    void 사용자입력값테스트_게임재시작혹은종료_범위오류(){
        assertThatThrownBy(
                () -> {
                    new UserInputGameStatusNumberValidator("3").isValidValue();
                }
        )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching(ErrorMessage.WRONG_NUMBER_MESSAGE);
    }
}