package baseball.controllers;

import baseball.constants.GameOption;
import baseball.constants.GameView;
import baseball.domains.Computer;
import baseball.domains.Player;
import baseball.domains.Score;
import baseball.views.CompleteMenuView;
import baseball.views.InputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private final Computer computer;
    private final static String COMPLETE_MESSAGE = GameOption.INPUT_LENGTH + "스트라이크";

    public BaseballController() {
        final Computer computer = new Computer();
        computer.play();
        this.computer = computer;
    }
    public GameView inputView() {
        return InputView.render(this);
    }

    public GameView calculateScore(Player player) {
        final String resultMessage = Score.calculate(player, computer);
        System.out.println(resultMessage);
        if (!resultMessage.equals(COMPLETE_MESSAGE)) {
            return GameView.INPUT;
        }
        return GameView.COMPLETE_MENU;
    }

    public GameView completeMenuView() {
        return CompleteMenuView.render(this);
    }

    public GameView restartOrExitConfirm() {
        final boolean isRestart = Console.readLine().equals("1");
        if (isRestart) {
            computer.play();
            return GameView.INPUT;
        }
        return GameView.BYE;
    }
}
