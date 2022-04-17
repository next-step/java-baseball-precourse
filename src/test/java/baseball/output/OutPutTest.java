package baseball.output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OutPutTest {

    private OutPut outPut = new OutPut();

    @Test
    @DisplayName("게임 메시지 테스트")
    void gameMessageTest() {
        assertThat(outPut.getGameMessage()).isEqualTo("숫자를 입력해주세요 : ");
        assertThat(outPut.getRestartMessage()).isEqualTo("재시작 하시겠습니까? (y/n)");
    }

    @Test
    @DisplayName("힌트 메시지 테스트")
    void hintMessageTest() {
        int strike = 1;
        int ball = 2;
        assertThat(outPut.getHintMessage(strike,ball)).isEqualTo(String.format("%d 스트라이크 %d 볼", strike, ball));
    }
}