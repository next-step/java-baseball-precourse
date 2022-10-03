package baseball.domain;

import baseball.ui.Input;
import baseball.ui.Output;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameMachineTest {

    @DisplayName("BaseBallGameMachine 통합 시각화 테스트 - 3스트라이크 , 게임종료")
    @Test
    void baseBallGameMachineTest() {
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine(new Input() {
            @Override
            public List<Integer> userPickNumbers() {
                return Arrays.asList(1, 2, 3);
            }

            @Override
            public int wantRetry() {
                return 2;
            }
        }, new Output() {
            @Override
            public void printResult(String GameResultString) {
                System.out.println(GameResultString);
            }

            @Override
            public void printFinish() {
                System.out.println("게임 종료");
            }
        }, () -> Arrays.asList(1, 2, 3));

        baseBallGameMachine.startGame();
    }
}
