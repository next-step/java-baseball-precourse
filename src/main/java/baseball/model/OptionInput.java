package baseball.model;

import baseball.domain.GameState;
import baseball.view.InputView;

public class OptionInput {

    public GameState getOption() throws IllegalArgumentException {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String userinput = InputView.getUserInput();

        if (!validateOptionInput(userinput)) {
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
        }

        return GameState.getGameState(Integer.parseInt(userinput));
    }

    private boolean validateOptionInput(String opinion) {
        String regexStr = String.format("%s|%s", 1, 2);
        return opinion.matches(regexStr);
    }
}
