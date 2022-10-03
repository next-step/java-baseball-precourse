package baseball.view;

import static baseball.utils.Constants.THREE_STRIKE_GAME_END;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MatchViewTest extends NsTest {
    @Test
    void nothingTest() {
        MatchView matchView = new MatchView();
        matchView.showGameResult(0, 0);
        Assertions.assertThat(output()).contains("낫싱");
        matchView.showGameResult(1, 0);
        Assertions.assertThat(output()).contains("1스트라이크");
        matchView.showGameResult(1, 1);
        Assertions.assertThat(output()).contains("1스트라이크 1볼");
        matchView.showGameResult(2, 1);
        Assertions.assertThat(output()).contains("2스트라이크 1볼");
        matchView.showGameResult(1, 2);
        Assertions.assertThat(output()).contains("1스트라이크 2볼");
        matchView.showGameResult(0, 3);
        Assertions.assertThat(output()).contains("3볼");
        matchView.showGameResult(3, 0);
        Assertions.assertThat(output()).contains(THREE_STRIKE_GAME_END);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
