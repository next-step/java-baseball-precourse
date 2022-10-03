package baseball.model;

import baseball.view.ComputerView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        Ball ball = new Ball();
        BallJudgment ballJudgment = new BallJudgment();
        ComputerView computerView = new ComputerView();
        computer = new Computer(ball, ballJudgment, computerView);

        computer.generateBallNumber();
    }

    @ParameterizedTest
    @DisplayName("플레이어 게임 승리")
    @CsvSource(value = {"2:false", "3:true", "1:false", "0:false", "4:false"}, delimiter = ':')
    void playerGameWin(int strikeCount, boolean expected) {
        boolean result = computer.playerGameWin(strikeCount);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력 결과 출력 전 볼 / 스트라이크 판단 결과 확인")
    @CsvSource(value = {"2:3:2볼 3스트라이크", "0:0:''", "1:0:1볼", "0:1:1스트라이크"}, delimiter = ':')
    void gameResultString(int ballCount, int strikeCount, String expected) {
        String result = computer.gameResultString(ballCount, strikeCount);

        assertThat(result).isEqualTo(expected);
    }
}
