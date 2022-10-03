package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.RandomUtil;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilsTest {

  //랜덤수 생성
  @Test
  @DisplayName("랜덤 숫자 3자리 생성 , 제공하는 Randoms에 3개의 랜덤수 생성 확인")
  void getRandomNumbers() {
    List<Integer> randomNumbers = RandomUtil.getRandomNumbers();
    assertThat(3).isEqualTo(randomNumbers.size());
  }



}
