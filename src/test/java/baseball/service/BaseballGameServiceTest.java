package baseball.service;

import baseball.Application;
import baseball.domain.Pitches;
import baseball.domain.StrikeBalls;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameServiceTest extends NsTest {
    @Test
    void 스트라이크_개수_카운트_테스트() {
        int expected = 3;
        BaseballGameService baseballGameService = new BaseballGameService();
        StrikeBalls strikeBalls = new StrikeBalls();
        String strikeBallVal = new String();
        for (int i = 0; i < 3; i++) {
            strikeBallVal += strikeBalls.getStrikeBall(i);
        }
        Pitches pitches = new Pitches(strikeBallVal);
        int cntStrike = baseballGameService.getStrikeCount(strikeBalls, pitches);

        assertThat(cntStrike == expected);

    }

    @Test
    void 볼_개수_카운트_테스트() {
        int expected = 3;
        BaseballGameService baseballGameService = new BaseballGameService();
        StrikeBalls strikeBalls = new StrikeBalls();
        String sampleUserInput = new String();
        for (int i = 3; i > 0; i--) {
            sampleUserInput += strikeBalls.getStrikeBall(i-1);
        }

        Pitches pitches = new Pitches(sampleUserInput);
        int cntBall = baseballGameService.getBallCount(strikeBalls, pitches);

        assertThat(cntBall == expected);

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
