package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static baseball.Score.ScoreEnum.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Score 클래스")
class ScoreTest {

    @Nested
    @DisplayName("isWinTheGame 메서드는")
    class Describe_isWinTheGame {

        @Nested
        @DisplayName("ScoreEnum이 모두 STRIKE로 주어지면")
        class Context_3_strike {
            Score subject() {
                return new Score(Arrays.asList(STRIKE, STRIKE, STRIKE), 3);
            }
            @Test
            @DisplayName("true 를 리턴한다.")
            void it_returns_true() {
                assertThat(subject().isWinTheGame()).isTrue();
            }
        }

        @Nested
        @DisplayName("ScoreEnum이 1BALL 2STRIKE로 주어지면")
        class Context_1_ball_2_strike {
            Score subject() {
                return new Score(Arrays.asList(STRIKE, STRIKE, BALL), 3);
            }
            @Test
            @DisplayName("false 를 리턴한다.")
            void it_returns_true() {
                assertThat(subject().isWinTheGame()).isFalse();
            }
        }
    }

    @Nested
    @DisplayName("scoreMap 메서드는")
    class Describe_scoreMap {

        @Nested
        @DisplayName("1BALL 1STRIKE 1NOTHING이 주어지면")
        class Context_1_ball_1_strike_1_nothing {

            Score subject() {
                return  new Score(Arrays.asList(STRIKE, BALL, NOTHING), 3);
            }
            @Test
            @DisplayName("Map<ScoreEnum, Integer> 형태로 enum 개수를 리턴한다.")
            void it_returns_ss() {
                Map<Score.ScoreEnum, Integer> expectedMap = new HashMap<>();
                expectedMap.put(STRIKE, 1);
                expectedMap.put(BALL, 1);
                expectedMap.put(NOTHING, 1);
                assertThat(subject().scoreMap())
                        .isEqualTo(expectedMap);
            }
        }
    }
}