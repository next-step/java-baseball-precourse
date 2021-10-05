package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputViewTest {
  @DisplayName("숫자야구 입력 테스트")
  @Test
  public void numberInput() {
    // given
    String input = "512";

    // when
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // then
    Assertions.assertThat("512").isEqualTo(InputView.numberInput());
  }

  @DisplayName("재시작 여부 입력 테스트")
  @Test
  public void restartInput() {
    // given
    String input = "1";

    // when
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // then
    Assertions.assertThat("1").isEqualTo(InputView.restartInput());
  }
}