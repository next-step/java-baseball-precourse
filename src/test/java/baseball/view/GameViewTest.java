package baseball.view;

import baseball.domain.CompareResult;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameViewTest {
    private OutputStream capture;

    @BeforeEach
    void before() {
        capture = new ByteOutputStream();
        System.setOut(new PrintStream(capture));
    }

    @DisplayName("입력요청 문구 확인")
    @Test
    void requestMessage() {
        InputReader inputReader = mock(InputReader.class);
        GameView view = new GameView(inputReader);

        when(inputReader.readBallNumber()).thenReturn(null);
        view.inputUserNumber();

        assertThat(capture.toString())
                .contains("숫자를 입력해주세요");
    }

    @DisplayName("비교결과출력_낫싱")
    @Test
    void show_nothing() {
        CompareResult compareResult = mock(CompareResult.class);
        GameView view = new GameView(null);

        when(compareResult.isNothing()).thenReturn(true);
        view.showCompareResult(compareResult);

        assertThat(capture.toString()).contains("낫싱");
    }

    @DisplayName("비교결과출력_1볼, 2스트라이크")
    @Test
    void show_1strike_1ball() {
        CompareResult compareResult = mock(CompareResult.class);
        GameView view = new GameView(null);

        when(compareResult.isNothing()).thenReturn(false);
        when(compareResult.getStrike()).thenReturn(1);
        when(compareResult.getBall()).thenReturn(1);
        view.showCompareResult(compareResult);

        assertThat(capture.toString()).contains("1볼 1스트라이크");
    }

    @DisplayName("비교결과출력_2볼, 1스트라이크")
    @Test
    void show_2ball_1strike() {
        CompareResult compareResult = mock(CompareResult.class);
        GameView view = new GameView(null);

        when(compareResult.isNothing()).thenReturn(false);
        when(compareResult.getStrike()).thenReturn(1);
        when(compareResult.getBall()).thenReturn(2);
        view.showCompareResult(compareResult);

        assertThat(capture.toString()).contains("2볼 1스트라이크");
    }

    @DisplayName("비교결과출력_3스트라이크")
    @Test
    void show_3strike() {
        CompareResult compareResult = mock(CompareResult.class);
        GameView view = new GameView(null);

        when(compareResult.isNothing()).thenReturn(false);
        when(compareResult.getStrike()).thenReturn(3);
        when(compareResult.getBall()).thenReturn(0);
        when(compareResult.isSuccess()).thenReturn(true);
        view.showCompareResult(compareResult);

        assertThat(capture.toString()).contains("3스트라이크", "게임 종료");
    }

    @DisplayName("게임 재시작 확인 문구")
    @Test
    void retryMessage() {
        InputReader inputReader = mock(InputReader.class);
        GameView view = new GameView(inputReader);

        when(inputReader.readReGameFlag()).thenReturn(true);
        view.askReGame();

        assertThat(capture.toString())
                .contains("새로 시작하려면 1", "종료하려면 2", "입력");
    }
}