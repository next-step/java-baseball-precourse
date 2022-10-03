package baseball.domain;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultTest {

    @DisplayName("0볼 0스트라이크 인 경우는 낫싱이 출력된다.")
    @Test
    void nothing() {
        GameResult gameResult = new GameResult();

        gameResult.report(NOTHING);
        gameResult.report(NOTHING);
        gameResult.report(NOTHING);

        assertThat(gameResult.toString()).isEqualTo("낫싱");
    }

    @DisplayName("스트라이크만 기록된 경우 - {}스트라이크로 출력된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void strike(int numberOfStrike) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < numberOfStrike; i++) {
            gameResult.report(STRIKE);
        }

        assertThat(gameResult.toString()).isEqualTo(numberOfStrike + "스트라이크");
    }

    @DisplayName("볼만 기록된 경우 - {}볼로 출력된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void ball(int numberOfBall) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < numberOfBall; i++) {
            gameResult.report(BALL);
        }

        assertThat(gameResult.toString()).isEqualTo(numberOfBall + "볼 ");
    }

    @DisplayName("볼과 스트라이크 모두가 기록된 경우 - {}볼 {}스트라이크로 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:1", "1:2"}, delimiter = ':')
    void ballAndStrike(int numberOfBall, int numberOfStrike) {
        GameResult gameResult = new GameResult();

        for (int i = 0; i < numberOfBall; i++) {
            gameResult.report(BALL);
        }

        for (int i = 0; i < numberOfStrike; i++) {
            gameResult.report(STRIKE);
        }

        assertThat(gameResult.toString()).isEqualTo(numberOfBall + "볼 " + numberOfStrike + "스트라이크");

    }

    @DisplayName("스트라이크가 3개인 경우 아웃이다.")
    @Test
    void out() {
        GameResult gameResult = new GameResult();

        gameResult.report(STRIKE);
        gameResult.report(STRIKE);
        gameResult.report(STRIKE);

        assertThat(gameResult.isOut()).isTrue();
    }

}
