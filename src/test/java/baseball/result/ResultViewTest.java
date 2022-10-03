package baseball.result;

import baseball.input.InputView;
import baseball.input.bean.Player;
import baseball.result.bean.Computer;
import baseball.result.bean.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("결과 테스트")
public class ResultViewTest {
    private ResultView resultView;
    private ResultMaker resultMaker;
    private Result result;
    private InputView inputView;
    private Player player;
    private Computer computer;
    @BeforeEach
    void setUp() {
        this.resultView = new ResultView();
        this.resultMaker = new ResultMaker();
        this.result = new Result();
        this.inputView = new InputView();
        this.player = new Player();
        this.computer = new Computer();
    }

    @DisplayName("야구게임 재시작, 종료 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, false"
    })
    void isRestartGame(String restartCode, boolean expected) {
        this.inputView = new InputView();
        String actualCode = restartCode;
        boolean actual = this.resultView.resultRestartGame(actualCode);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("야구게임 재시작, 종료 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "savd11",
            "svdasdvewds21e12e",
            "3",
            "123",
            "142"
    })
    void isRestartGameException(String restartCode) {
        assertThatThrownBy(() -> {
            this.inputView = new InputView();
            String actualCode = restartCode;
            this.resultView.resultRestartGame(restartCode);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
