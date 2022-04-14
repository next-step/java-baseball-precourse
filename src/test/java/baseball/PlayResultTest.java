package baseball;

import baseball.balls.Balls;
import baseball.balls.PlayResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PlayResultTest {

    private Balls computer;

    @BeforeEach
    void setUp() {
        computer = new Balls(Arrays.asList(1, 4, 5));
    }

    @Test
    @DisplayName("낫싱 - 일치하는 숫자가 없는 경우")
    void test01() {
        PlayResult result = computer.play(Arrays.asList(2, 6, 3));
        Assertions.assertThat(result.getStrike()).isEqualTo(0);
        Assertions.assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 - 숫자는 같지만 입력 위치가 다른 경우")
    void test02() {
        PlayResult result = computer.play(Arrays.asList(2, 1, 3));
        Assertions.assertThat(result.getStrike()).isEqualTo(0);
        Assertions.assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크 - 숫자와 입력 위치가 같은 경우")
    void test03() {
        PlayResult result = computer.play(Arrays.asList(1, 4, 3));
        Assertions.assertThat(result.getStrike()).isEqualTo(2);
        Assertions.assertThat(result.getBall()).isEqualTo(0);
        Assertions.assertThat(result.isGameOver()).isFalse();
    }

    @Test
    @DisplayName("3스트라이크 - 게임 종료 조건")
    void test04() {
        PlayResult result = computer.play(Arrays.asList(1, 4, 5));
        Assertions.assertThat(result.getStrike()).isEqualTo(3);
        Assertions.assertThat(result.getBall()).isEqualTo(0);
        Assertions.assertThat(result.isGameOver()).isTrue();
    }
}
