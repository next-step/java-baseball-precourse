package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameBallValidationTest {
    @Test
    @DisplayName("입력한숫자의중복테스트")
    void valdateNumberDuplicateTest() {
        assertThat(GameBallValidateUtils.isDulicateNumbers(Arrays.asList(1,1,2))).isTrue();
        assertThat(GameBallValidateUtils.isDulicateNumbers(Arrays.asList(1,3,2))).isFalse();
    }

    @Test
    @DisplayName("입력한숫자의유효자릿수테스트")
    void validateNumberDigitTest() {
        assertThat(GameBallValidateUtils.isValidNumbersDigit(Arrays.asList(1,2,3))).isTrue();
        assertThat(GameBallValidateUtils.isValidNumbersDigit(Arrays.asList(1,2,3,4))).isFalse();
        assertThat(GameBallValidateUtils.isValidNumbersDigit(Arrays.asList(1,2))).isFalse();
    }

    @Test
    @DisplayName("입력한숫자의유효범위테스트")
    void validateNumberRangeTest() {
        assertThat(GameBallValidateUtils.isValidNumbersRange(Arrays.asList(1,2,3))).isTrue();
        assertThat(GameBallValidateUtils.isValidNumbersRange(Arrays.asList(1,0,3))).isFalse();
        assertThat(GameBallValidateUtils.isValidNumbersRange(Arrays.asList(10,2,3))).isFalse();
    }

    @DisplayName("게임에 유효한 숫자범위 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, 0, 10, 11, 12, 100})
    void validateNumberRangeFailTest(int userInputNumber) {
        assertThat(GameBallValidateUtils.isValidNumberRange(userInputNumber)).isFalse();
        assertFalse(GameBallValidateUtils.isValidNumberRange(userInputNumber));
    }

    @DisplayName("게임에 유효한 숫자범위 성공 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void validateNumberRangeSuccessTest(int userInputNumber) {
        assertThat(GameBallValidateUtils.isValidNumberRange(userInputNumber)).isTrue();
        assertTrue(GameBallValidateUtils.isValidNumberRange(userInputNumber));
    }
}
