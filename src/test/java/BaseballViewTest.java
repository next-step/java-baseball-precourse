import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballViewTest {
    BaseballView baseballView = new BaseballView();
    final int LENGTH = 3;
    final int LO = 1;
    final int HI = 9;

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "149", "237"})
    @DisplayName("사용자 입력 유효성 통과 테스트")
    void validateUserInputSuccess(String userInput) {
        assertThat(baseballView.validateUserNumber(userInput, LENGTH, LO, HI));
    }

    @Test
    @DisplayName("사용자 입력 유효성 실패 - 길이 오류")
    void validateUserInputFailWhenInvalidLength() {
        String userInput = "1233";
        assertThat(baseballView.validateUserNumber(userInput, LENGTH, LO, HI));
    }

    @Test
    @DisplayName("사용자 입력 유효성 실패 - 범위에 맞지 않는 수")
    void validateUserInputFailWhenInvalidInputRange() {
        String userInput = "019";
        assertThat(baseballView.validateUserNumber(userInput, LENGTH, LO, HI));
    }

    @Test
    @DisplayName("사용자 입력 유효성 실패 - 숫자가 아닌 입력")
    void validateUserInputFailWhenInvalidInput() {
        String userInput = "abc";
        assertThat(baseballView.validateUserNumber(userInput, LENGTH, LO, HI));
    }
}
