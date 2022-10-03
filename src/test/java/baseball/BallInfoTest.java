package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BallInfo;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallInfoTest {

  private BallInfo ballInfo;

  @BeforeEach
  void setUp() {
    ballInfo.setUserBalls(Arrays.asList(1, 2, 3));
    ballInfo.setComputerBalls(Arrays.asList(5, 1, 3));
  }

  @Test
  @DisplayName("볼정보 입력후 스트라이크 판독 ")
  void strikeCount() {
    ballInfo.score();
    assertThat(1).isEqualTo(ballInfo.getStrikeCnt());

  }

  @Test
  @DisplayName("볼정보 입력후 볼 판독 ")
  void ballCount() {
    ballInfo.score();
    assertThat(1).isEqualTo(ballInfo.getBallCnt());
  }

}
