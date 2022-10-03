package baseball.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameValidatorTest {

    @DisplayName("사용자 입력(게임 번호)이 유효한지 검증")
    @ParameterizedTest(name = "사용자 입력: {0}, 기대값: {1}, 내용: {2}")
    @CsvSource({"123, true, 정상입력", "000, false, 중복숫자", "1234, false, 게임사이즈 불일치", "01, false, 게임사이즈 불일치"})
    void isValidGameNumbers(String source, boolean expected, String description) {
        // when
        boolean result = GameValidator.isValidGameNumbers(source);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사용자 입력(게임 재시작 번호)이 유효한지 검증")
    @ParameterizedTest(name = "사용자 입력: {0}, 기대값: {1}, 내용: {2}")
    @CsvSource({"1, true, 정상입력", "2, true, 정상입력", "12, false, 단일숫자 검증 불일치", "3, false, 게임 시스템에 미포함된 코드"})
    void isValidRestartNumber(String source, boolean expected, String description) {
        // when
        boolean result = GameValidator.isValidRestartNumber(source);

        // then
        assertThat(result).isEqualTo(expected);
    }
}