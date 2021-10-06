package baseball;

import baseball.domain.GameBall;
import baseball.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBallTest {

    //테스트 중복코드 메소드로 작성
    GameResult getTestGameResult(List<Integer> computerBallNums, List<Integer> userBallNums) {
        GameBall computerBall = new GameBall(computerBallNums);
        GameBall userInputBall = new GameBall(userBallNums);
        return computerBall.playball(userInputBall);
    }

    @Test
    @DisplayName("나싱테스트")
    void nothingTest() {
        GameResult notingResult = getTestGameResult(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        assertThat(notingResult.getBallCnt()).isEqualTo(0);
        assertThat(notingResult.getStrikeCnt()).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크테스트")
    void strikeTest() {
        GameResult strikeResult = getTestGameResult(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        assertThat(strikeResult.getStrikeCnt()).isEqualTo(3);
    }

    @Test
    @DisplayName("볼테스트")
    void ballTest() {
        GameResult ballResult = getTestGameResult(Arrays.asList(1, 2, 3), Arrays.asList(2, 5, 6));
        assertThat(ballResult.getBallCnt()).isGreaterThan(0);
        assertThat(ballResult.getBallCnt()).isEqualTo(1);
    }

    @Test
    @DisplayName("1스트라이크1볼테스트")
    void oneStrikeOneBallTest() {
        GameResult strikeBallResult = getTestGameResult(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 6));
        assertThat(strikeBallResult.getBallCnt()).isEqualTo(1);
        assertThat(strikeBallResult.getStrikeCnt()).isEqualTo(1);
    }
}
