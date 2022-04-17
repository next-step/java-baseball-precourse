package baseball.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static baseball.output.OutPutEnum.*;

import static org.assertj.core.api.Assertions.*;

class OutPutTest {

    private OutPut outPut = new OutPut();

    @Test
    @DisplayName("게임 메시지 테스트")
    void gameMessageTest() {
        assertThat(outPut.getGameMessage()).isEqualTo(GAME_MESSAGE.text());
        assertThat(outPut.getRestartMessage()).isEqualTo(RESTART_MESSAGE.text());
    }

    @Test
    @DisplayName("힌트 메시지 테스트")
    void hintMessageTest() {
        int strike = 1;
        int ball = 2;
        assertThat(outPut.getHintMessage(strike,ball)).isEqualTo(String.format("%d볼 %d스트라이크", ball, strike));
    }

    @Test
    @DisplayName("게임종료 메시지 테스트")
    void endMessageTest() {
        assertThat(outPut.getEndMessage()).isEqualTo(END_MESSAGE.text());
    }
}