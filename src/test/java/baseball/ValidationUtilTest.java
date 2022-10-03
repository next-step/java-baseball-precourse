package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import baseball.util.ValidationUtil;

public class ValidationUtilTest {


  // 1~9 숫자 인지 확인
  @Test
  @DisplayName("입력 값 숫자인지   1-9 값 확인")
  void isNumber() {

    assertThat(ValidationUtil.isNumber(0)).isFalse();
    assertThat(ValidationUtil.isNumber(1)).isTrue();
    assertThat(ValidationUtil.isNumber(12)).isFalse();
    assertThat(ValidationUtil.isNumber(9)).isTrue();
  }

  //  입력 숫자 길이 확인
  @Test
  @DisplayName("입력값 3자리 인지 확인")
  void isLength() {

    assertThat(ValidationUtil.isLength(Arrays.asList(1))).isFalse();
    assertThat(ValidationUtil.isLength(Arrays.asList(1, 2))).isFalse();
    assertThat(ValidationUtil.isLength(Arrays.asList(1, 2, 3))).isTrue();
    assertThat(ValidationUtil.isLength(Arrays.asList(1, 2, 3, 4))).isFalse();
  }

  @Test
  @DisplayName("입력 값 증복 확인")
    void isDuplication() {

      assertThat(ValidationUtil.isDuplication(Arrays.asList(1, 2, 3))).isTrue();
      assertThat(ValidationUtil.isDuplication(Arrays.asList(1, 2, 2))).isFalse();
      assertThat(ValidationUtil.isDuplication(Arrays.asList(1, 1, 1))).isFalse();
  }




}
