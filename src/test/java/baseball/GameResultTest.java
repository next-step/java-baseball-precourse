package baseball;

import baseball.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    @DisplayName("게임결과스트라이크테스트")
    void gameResultStrikeTest() {
        GameResult gameResult = new GameResult();
        gameResult.setStrike();
        gameResult.setStrike();
        assertThat(gameResult.getStrikeCnt()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임결과볼테스트")
    void gameResulBallTest() {
        GameResult gameResult = new GameResult();
        gameResult.setBall();
        gameResult.setBall();
        assertThat(gameResult.getBallCnt()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임결과나싱테스트")
    void gameResulNothingTest() {
        GameResult gameResult = new GameResult();
        assertThat(gameResult.getStrikeCnt()).isEqualTo(0);
        assertThat(gameResult.getBallCnt()).isEqualTo(0);
    }

    @Test
    @DisplayName("게임결과게임오버여부테스트")
    void gameResultTest() {
        GameResult gameResult = new GameResult();
        assertThat(gameResult.isGameOver()).isFalse();

        gameResult.setStrike();
        gameResult.setStrike();
        gameResult.setStrike();
        assertThat(gameResult.isGameOver()).isTrue();
    }
}
