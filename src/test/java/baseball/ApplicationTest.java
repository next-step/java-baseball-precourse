package baseball;

import baseball.controller.MatchController;
import baseball.model.Match;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void existRestart() {
        Player inputPlayer = new Player();
        Player guessPlayer = new Player();
        guessPlayer.setNumbers(Arrays.asList(3, 9, 2));
        Match match = new Match(inputPlayer, guessPlayer);
        match.setInputPlayerNumber(Arrays.asList(8, 7, 1));
        assertThat(match.getPlayerBallCount()).isEqualTo(0);
        assertThat(match.getPlayerStrikeCount()).isEqualTo(0);
    }

    /*@Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }*/

    @Test
    void exceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
