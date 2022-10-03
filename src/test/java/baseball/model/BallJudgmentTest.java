package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallJudgmentTest {
    private BallJudgment ballJudgment;

    @BeforeEach
    void setUp() {
        ballJudgment = new BallJudgment();
    }

    @ParameterizedTest
    @DisplayName("스트라이크 판단")
    @CsvSource(value = {"724:752:1", "125:125:3", "532:264:0"}, delimiter = ':')
    void judgmentStrikeCount(int computerBallNumber, int playerBallNumber, int expected) {
        String[] computerBallNumberStringArray = ballJudgment.convertIntToStringArray(computerBallNumber);
        String[] playerBallNumberStringArray = ballJudgment.convertIntToStringArray(playerBallNumber);

        int count = ballJudgment.countStrike(computerBallNumberStringArray, playerBallNumberStringArray);

        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("볼 갯수 확인")
    @CsvSource(value = {"724:752:1", "125:125:0", "532:264:1"}, delimiter = ':')
    void judgmentBallCount(int computerBallNumber, int playerBallNumber, int expected) {
        String[] computerBallNumberStringArray = ballJudgment.convertIntToStringArray(computerBallNumber);
        String[] playerBallNumberStringArray = ballJudgment.convertIntToStringArray(playerBallNumber);

        int count = ballJudgment.countBall(computerBallNumberStringArray, playerBallNumberStringArray);

        assertThat(count).isEqualTo(expected);
    }
}
