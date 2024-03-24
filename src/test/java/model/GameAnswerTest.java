package model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("GameAnswer 단위 테스트")
class GameAnswerTest {

    private final GameAnswer gameAnswer = new GameAnswer(new RandomGenerator() {
        @Override
        public List<Integer> generateRandomNumber(int numOfDigit) {
            return List.of(1, 2, 3);
        }
    });

    @Nested
    @DisplayName("calculateGameResult: 게임 결과를 반환한다.")
    class calculateGameResult_UnitTest {

        @Test
        @DisplayName("자릿수가 일치하는 숫자만큼 스트라이크를 반환한다.")
        void test1() {
            final GameResult result = gameAnswer.calculateGameResult(new GameInput("120"));
            assertThat(result.getNumOfStrike()).isEqualTo(2);
            assertThat(result.getNumOfBall()).isEqualTo(0);
        }

        @Test
        @DisplayName("자릿수는 다르지만 일치하는 숫자만큼 볼을 반환한다.")
        void test2() {
            final GameResult result = gameAnswer.calculateGameResult(new GameInput("012"));
            assertThat(result.getNumOfStrike()).isEqualTo(0);
            assertThat(result.getNumOfBall()).isEqualTo(2);
        }
    }
}
