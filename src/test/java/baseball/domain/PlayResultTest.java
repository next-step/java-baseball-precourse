package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayResultTest {

    @Test
    @DisplayName("스트라이크 시 strike + 1")
    void increase_strike() {
        PlayResult playResult = new PlayResult();
        playResult.increaseCount(BallStatus.STRIKE);

        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 시 strike + 1")
    void increase_ball() {
        PlayResult playResult = new PlayResult();
        playResult.increaseCount(BallStatus.BALL);

        assertThat(playResult.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("1스트라이크 1볼 힌트 출력")
    void print_hint_1S_1B() {
        PlayResult playResult = new PlayResult();
        playResult.increaseCount(BallStatus.STRIKE);
        playResult.increaseCount(BallStatus.BALL);

        assertThat(playResult.resultMessage().trim()).isEqualTo("1스트라이크 1볼");
    }

    @Test
    @DisplayName("1스트라이크 힌트 출력")
    void print_hint_1S() {
        PlayResult playResult = new PlayResult();
        playResult.increaseCount(BallStatus.STRIKE);

        assertThat(playResult.resultMessage().trim()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("2볼 힌트 출력")
    void print_hint_1B() {
        PlayResult playResult = new PlayResult();
        playResult.increaseCount(BallStatus.BALL);
        playResult.increaseCount(BallStatus.BALL);

        assertThat(playResult.resultMessage().trim()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("낫싱 힌트 출력")
    void print_hint() {
        PlayResult playResult = new PlayResult();

        assertThat(playResult.resultMessage().trim()).isEqualTo("낫싱");
    }
}