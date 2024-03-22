import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameModel 단위 테스트")
class GameModelTest {

    private final GameModel gameModel = new GameModel(new RandomGenerator() {
        @Override
        public List<Integer> generateRandomNumber(int numOfDigit) {
            return List.of(1, 2, 3);
        }
    });

    @Nested
    @DisplayName("isGameEnd: 게임 종료 여부를 반환한다.")
    class isGameEnd_UnitTest {

        @Test
        @DisplayName("게임이 종료 조건을 달성하면 true 를 반환한다.")
        void test1() {
            final boolean result = gameModel.isGameEnd("123");
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("게임이 종료 조건을 달성하지 못하면 false 를 반환한다.")
        void test2() {
            final boolean result = gameModel.isGameEnd("234");
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("calculateGameResult: 게임 결과를 반환한다.")
    class calculateGameResult_UnitTest {

        @Test
        @DisplayName("자릿수가 일치하는 숫자만큼 스트라이크를 반환한다.")
        void test1() {
            final int[] result = gameModel.calculateGameResult("120");
            assertThat(result[0]).isEqualTo(2);
            assertThat(result[1]).isEqualTo(0);
        }

        @Test
        @DisplayName("자릿수는 다르지만 일치하는 숫자만큼 볼을 반환한다.")
        void test2() {
            final int[] result = gameModel.calculateGameResult("012");
            assertThat(result[0]).isEqualTo(0);
            assertThat(result[1]).isEqualTo(2);
        }
    }
}