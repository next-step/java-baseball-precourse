package baseball.validation;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BaseBallValidationTest {
  @DisplayName("입력 받은 유효하지 않은 문자열 검사")
  @ParameterizedTest
  @ValueSource(strings = {"ab1", "!a3", "12 3!", "2 34", " 21", "221"})
  void checkInvalidInputNumber(String input) {
    assertThat(BaseBallValidation.checkInputNumber(input)).isFalse();
  }

  @DisplayName("입력 받은 유효한 문자열 검사")
  @ParameterizedTest
  @ValueSource(strings = {"123", "234", "512", "891", "129", "938"})
  void checkValidInputNumber(String input) {
    assertThat(BaseBallValidation.checkInputNumber(input)).isTrue();
  }

  @DisplayName("입력 받은 게임 재시작 종료 문자열 검사")
  @Test
  void checkRestartInputNumber() {
    String start = "1";
    String end = "2";
    String otherwise = "3";

    assertThat(BaseBallValidation.checkRestartInputNumber(start)).isTrue();
    assertThat(BaseBallValidation.checkRestartInputNumber(end)).isTrue();
    assertThat(BaseBallValidation.checkRestartInputNumber(otherwise))
      .isFalse()
      .as("1, 2가 아닌 번호를 입력할 경우");
  }
}