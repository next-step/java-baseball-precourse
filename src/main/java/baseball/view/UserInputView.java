package baseball.view;

import java.util.List;

public class UserInputView {
    private final InputReader inputReader;

    public UserInputView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    List<Integer> inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return inputReader.readBallNumber();
    }
}
