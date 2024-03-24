package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultCalculatorTest {

    @CsvSource({
            "425,123,1,0",
            "425,456,1,1",
            "425,789,0,0"
    })
    @DisplayName("스트라이크/볼 개수를 올바르게 계산합니다.")
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    void calculate(int target, int guess, int strikeCount, int ballCount) {
        // given, when
        GameResult result = GameResultCalculator.calculate(BaseballNumber.of(target), BaseballNumber.of(guess));

        assertAll(() -> {
            assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
            assertThat(result.getBallCount()).isEqualTo(ballCount);
        });
    }
}