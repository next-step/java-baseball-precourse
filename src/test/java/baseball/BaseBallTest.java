package baseball;

import static enums.Errors.INPUT_ERROR_AND_REINPUT;
import static enums.Errors.getDesc;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseBallTest {

  @Test
  void 숫자가_아닌_input() {
    BaseBall baseBall = new BaseBall(asList('7','1','2'));

    assertThat(baseBall.getState("zzz"))
        .isEqualTo(getDesc(INPUT_ERROR_AND_REINPUT));
  }

  @Test
  void 세글자가_넘는_input() {
    BaseBall baseBall = new BaseBall(asList('7','1','2'));

    assertThat(baseBall.getState("1111"))
        .isEqualTo(getDesc(INPUT_ERROR_AND_REINPUT));
  }

  @Test
  void 중복_input() {
    BaseBall baseBall = new BaseBall(asList('7','1','2'));

    assertThat(baseBall.getState("111"))
        .isEqualTo(getDesc(INPUT_ERROR_AND_REINPUT));
  }

  @Test
  void 스트라이크() {
    BaseBall baseBall = new BaseBall(asList('7','1','2'));

    assertThat(baseBall.getState("709"))
        .isEqualTo("1스트라이크");
    assertThat(baseBall.isAnswer()).isFalse();

    assertThat(baseBall.getState("710"))
        .isEqualTo("2스트라이크");
    assertThat(baseBall.isAnswer()).isFalse();

    assertThat(baseBall.getState("712"))
        .isEqualTo("3스트라이크");
    assertThat(baseBall.isAnswer()).isTrue();
  }

  @Test
  void 볼_스트라이크() {
    BaseBall baseBall = new BaseBall(asList('7','1','2'));

    assertThat(baseBall.getState("109"))
        .isEqualTo("1볼");
    assertThat(baseBall.isAnswer()).isFalse();

    assertThat(baseBall.getState("701"))
        .isEqualTo("1스트라이크 1볼");
    assertThat(baseBall.isAnswer()).isFalse();

    assertThat(baseBall.getState("271"))
        .isEqualTo("3볼");
    assertThat(baseBall.isAnswer()).isFalse();
  }
}
