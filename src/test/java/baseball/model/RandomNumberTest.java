package baseball.model;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RandomNumberTest {
  int BASE_BALL_SIZE = 3;

  @Test
  @DisplayName("RandomNumber 객체 생성 시 유효한 랜덤수가 생성되었는지 테스트한다.")
  public void makeRandomNumber() {
    // given
    List<RandomNumber> randomNumbers = new ArrayList<>();

    // when
    for (int i = 0; i < Short.MAX_VALUE; i++) {
      randomNumbers.add(RandomNumber.makeRandomNumber());
    }

    // then
    for (RandomNumber randomNumber : randomNumbers) {
      assertThat(randomNumber.getNumber().size()).isEqualTo(BASE_BALL_SIZE);
    }
  }
}