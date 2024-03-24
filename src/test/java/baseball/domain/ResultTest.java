package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Result 클래스 테스트")
public class ResultTest {
    @Test
    @DisplayName("게임 종료 여부 테스트 - 게임 계속 진행")
    public void testResultIsOver() {
        Result result = new Result(3, 0, "3스트라이크");
        assertThat(result.isOver).isTrue();
    }

    @Test
    @DisplayName("게임 종료 여부 테스트 - 게임 종료")
    public void testResultIsNotOver() {
        Result result = new Result(2, 1, "2스트라이크 1볼");
        assertThat(result.isOver).isFalse();
    }
}
