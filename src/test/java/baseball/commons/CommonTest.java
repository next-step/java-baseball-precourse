package baseball.commons;

import baseball.exception.IncorrectInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonTest {
    @Test
    @DisplayName("중복 수 입력 IncorrectInputException 발생")
    void 비정상입력_1() {
        assertThrows(IncorrectInputException.class, () -> Common.isValidString("112", Constant.GAME_PITCHING_COUNT));
    }

    @Test
    @DisplayName("3자리보다 짧은 입력 IncorrectInputException 발생")
    void 비정상입력_2() {
        assertThrows(IncorrectInputException.class, () -> Common.isValidString("12", Constant.GAME_PITCHING_COUNT));
    }

    @Test
    @DisplayName("3자리보다 많은 입력 IncorrectInputException 발생")
    void 비정상입력_3() {
        assertThrows(IncorrectInputException.class, () -> Common.isValidString("1234", Constant.GAME_PITCHING_COUNT));
    }

    @Test
    @DisplayName("숫자가 아닌 문자 포함 IncorrectInputException 발생")
    void 비정상입력_4() {
        assertThrows(IncorrectInputException.class, () -> Common.isValidString("12ㄷ", Constant.GAME_PITCHING_COUNT));
    }
}