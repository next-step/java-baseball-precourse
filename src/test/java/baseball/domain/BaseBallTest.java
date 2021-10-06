package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {

    @DisplayName("3스트라이크 일 때 게임이 끝난 상태인지 테스트")
    @Test
    void gameEndTest() {
        BaseBall actual = new BaseBall(3, 0);

        assertThat(actual.isGameEnd()).isTrue();
    }

    @DisplayName("게임이 끝나지 않은 경우를 테스트")
    @ParameterizedTest
    @CsvSource({"2,1","1,1","1,0","1,2","0,3"})
    void gameIngTest(int strike, int ball) {
        BaseBall actual = new BaseBall(strike, ball);

        assertThat(actual.isGameEnd()).isFalse();
    }

    @DisplayName("낫싱인 경우를 테스트")
    @Test
    void nothingTrueTest() {
        BaseBall actual = new BaseBall(0, 0);

        assertThat(actual.isNothing()).isTrue();
    }

    @DisplayName("낫싱이 아닌 경우를 테스트")
    @ParameterizedTest
    @CsvSource({"2,1","1,1","1,0","1,2","0,3"})
    void notingFalseTest(int strike, int ball) {
        BaseBall actual = new BaseBall(strike, ball);

        assertThat(actual.isNothing()).isFalse();
    }
}
