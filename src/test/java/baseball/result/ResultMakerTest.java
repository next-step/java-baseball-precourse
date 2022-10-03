package baseball.result;

import baseball.input.bean.Player;
import baseball.result.bean.Computer;
import baseball.result.bean.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("결과 테스트")
public class ResultMakerTest {
    private ResultMaker resultMaker;
    private Player player;
    private Computer computer;
    @BeforeEach
    void setUp() {
        this.resultMaker = new ResultMaker();
        this.player = new Player();
        this.computer = new Computer();
    }

    @DisplayName("result 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            // nothing 123 456
            "123, 456, 0, 0, true, false",
            "123, 465, 0, 0, true, false",
            "123, 546, 0, 0, true, false",
            "123, 564, 0, 0, true, false",
            "123, 645, 0, 0, true, false",
            "123, 654, 0, 0, true, false",
            // 1 123 145
            "123, 145, 0, 1, false, false",
            "123, 154, 0, 1, false, false",
            "123, 415, 1, 0, false, false",
            "123, 451, 1, 0, false, false",
            "123, 514, 1, 0, false, false",
            "123, 541, 1, 0, false, false",
            // 2 123 134
            "123, 134, 1, 1, false, false",
            "123, 143, 0, 2, false, false",
            "123, 314, 2, 0, false, false",
            "123, 341, 2, 0, false, false",
            "123, 413, 1, 1, false, false",
            "123, 431, 2, 0, false, false",
            // 3 123 123
            "123, 123, 0, 3, false, true",
            "123, 132, 2, 1, false, false",
            "123, 213, 2, 1, false, false",
            "123, 231, 3, 0, false, false",
            "123, 312, 3, 0, false, false",
            "123, 321, 2, 1, false, false"
    })
    void result(String playerNumber, String computerNumber
            , int ballCountExpected
            , int strikeCountExpected
            , boolean nothingExpected
            , boolean gameOver
    ) {
        this.player.setNumbers(playerNumber);
        this.computer.setNumbers(computerNumber);
        this.resultMaker.setResult(new Result(new Counter(player, computer)));
        Result actual = this.resultMaker.getResult();
        assertThat(actual.getBallCount()).isEqualTo(ballCountExpected);
        assertThat(actual.getStrikeCount()).isEqualTo(strikeCountExpected);
        assertThat(actual.isNothing()).isEqualTo(nothingExpected);
        assertThat(actual.isGameOver()).isEqualTo(gameOver);
    }
}
