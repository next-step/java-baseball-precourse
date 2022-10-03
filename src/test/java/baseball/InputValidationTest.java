package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName    : baseball
 * fileName       : InputValidationTest
 * author         : BOM
 * date           : 2022-10-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-03        BOM       최초 생성
 */
class InputValidationTest {
    @DisplayName("사용자가 추측 입력값을 잘못 넣었을때의 exception test")
    @Test
    void validateInputNumberFromUserTest() {
        InputValidation inputValidation = new InputValidation(3);
        assertThatThrownBy(() -> inputValidation.validateInputNumberFromUser("abc"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("사용자가 재경기 의사값을 잘못 넣었을때의 exception test")
    @Test
    void validateRegameInputFromUserTest() {
        InputValidation inputValidation = new InputValidation(3);
        assertThatThrownBy(() -> inputValidation.validateRegameInputFromUser("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}