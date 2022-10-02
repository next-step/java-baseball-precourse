package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.code.BallCount;
import baseball.model.Balls.BallsBuilder;

@DisplayName("Balls 테스트")
public class BallsTest {

  @DisplayName("Balls Java Bean 생성테스트")
  @Test
  void createBallsJavaBean() {
    // given // when
    Balls balls = new Balls();
    // then
    assertThat(balls).isInstanceOf(Balls.class);
  }

  @DisplayName("Balls Builder 생성 테스트")
  @Test
  void createBallsBuilder() {
    // given // when
    Balls balls = new Balls.BallsBuilder().ballArray("123").build();
    // then
    assertAll(
        () -> assertThat(balls).isInstanceOf(Balls.class),
        () -> assertThat(balls.getBallList()).isInstanceOf(List.class)
    );
  }

  @DisplayName("Balls RandomBuilder 생성 테스트, Randoms를 사용한 무작위 겹치지 않는 세 가지 수 객체 생성")
  @Test
  void createRandomNumbersUsingBallRandomBuilderTest() {
    // given
    Balls balls = new Balls.BallsRandomsBuilder().build();
    // when
    List<Ball> ballList = balls.getBallList();
    // then
    assertAll(
        () -> assertThat(ballList).isInstanceOf(List.class),
        () -> assertThat(ballList).isNotNull(),
        () -> assertThat(ballList).hasSize(3),
        () -> assertThat(ballList.get(0)).isInstanceOf(Ball.class),
        () -> assertThat(ballList.get(0).compareBall(ballList.get(0))).isEqualTo(BallCount.STRIKE),
        () -> assertThat(ballList.get(0).getValue()).isNotEqualTo(ballList.get(1).getValue()),
        () -> assertThat(ballList.get(0).getValue()).isNotEqualTo(ballList.get(2).getValue()),
        () -> assertThat(ballList.get(1).getValue()).isNotEqualTo(ballList.get(2).getValue())
    );
  }

  @DisplayName("Balls Builder 플레이어 입력 값이 세 자리가 아니거나 중복 값이 존재하는 예외상황 테스트")
  @ParameterizedTest(name = "{index} ==> input {0}")
  @ValueSource(strings = {"12345", "1234", "4444", "4", "74", "2", "22"})
  void createPlayerBallsOver3NumbersException(String input) {
    assertThatThrownBy(() -> {
      new BallsBuilder().ballArray(input).build();
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("서로 다른 세자리 수를 입력 하세요.");
  }

  @DisplayName("Balls Builder 플레이어 입력 값이 빈 값인 예외상황 테스트")
  @Test
  void createPlayerBallsInputNull() {
    assertThatThrownBy(() -> {
      new BallsBuilder().ballArray("").build();
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("두 Balls를 비교하여 BallCountList를 만드는 함수 테스트")
  @Test
  void createBallCountListCompare() {
    // given
    Balls computerBalls = new Balls.BallsBuilder().ballArray("123").build();
    Balls playerBalls = new Balls.BallsBuilder().ballArray("123").build();
    // when
    List<BallCount> ballCountList = computerBalls.compareBalls(playerBalls);
    // then
    assertAll(
        () -> assertThat(ballCountList).isInstanceOf(List.class),
        () -> assertThat(ballCountList.size()).isEqualTo(9)
    );
  }

}