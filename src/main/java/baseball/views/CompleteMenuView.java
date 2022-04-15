package baseball.views;

import baseball.constants.GameOption;
import baseball.constants.GameView;
import baseball.controllers.BaseballController;

public class CompleteMenuView {
    public static GameView render(BaseballController controller) {
        System.out.println(GameOption.INPUT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return callApi(controller);
    }

    private static GameView callApi(BaseballController controller) {
        return controller.restartOrExitConfirm();
    }
}
