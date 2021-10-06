package baseball.model;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerStateTest {
    private PlayerState playerState;

    @BeforeEach
    void setup() {
        playerState = new PlayerState(Arrays.asList(1, 2, 3));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,3,0,0", "2,3,1,0,3,0", "4,5,6,0,0,3", "1,2,4,2,0,1", "2,3,5,0,2,1", "1,3,2,1,2,0"}, delimiter = ',')
    void Trial_객체를_입력받으면_PLAY_후의_STRIKE_BALL_NOTHING_개수를_리턴한다(
            int firstBallNum, int secondBallNum, int thirdBallNum,
            int expectStrikeCnt, int expectBallCnt, int expectNothingCnt) {
        Assertions
                .assertThat(playerState.play(new PlayerState(Arrays.asList(firstBallNum, secondBallNum, thirdBallNum))))
                .isEqualTo(new PlayResult(expectStrikeCnt, expectBallCnt, expectNothingCnt));
    }
}
