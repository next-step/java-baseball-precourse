package baseball.output;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class OutPutServiceTest {

    private OutPutService outPutService = new OutPutService();

    @Test
    @DisplayName("게임 메시지 출력")
    void gameMessageTest() {
        outPutService.printGameMessage();
        outPutService.printRestartMessage();
    }

    @Test
    @DisplayName("힌트 메시지 출력")
    void printHintMessageTest() {
        outPutService.printHintMessage(1,2);
    }
}