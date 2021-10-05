package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseBallCounterTest {
  @Test
  public void makeBaseBallCounter() {
    // given
    BaseBallCounter baseBallCounter = new BaseBallCounter("123");
    List<Integer> computerNumber = new ArrayList<>();
    computerNumber.add(1);
    computerNumber.add(3);
    computerNumber.add(4);

    // when
    baseBallCounter.count(computerNumber);

    // then
    assertThat(baseBallCounter.getStrike()).isEqualTo(1);
    assertThat(baseBallCounter.getBall()).isEqualTo(1);
    assertThat(baseBallCounter.hasNothing()).isFalse();
  }
}