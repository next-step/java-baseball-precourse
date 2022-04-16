package baseball.view;

import java.util.List;

public class GameView {
    private final InputReader inputReader;

    public GameView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    List<Integer> inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return inputReader.readBallNumber();
    }
}
