package baseball;

import baseball.controller.BaseBallGameController;
import baseball.controller.BaseBallGameControllerImpl;
import baseball.model.BaseBallGameModel;
import baseball.model.BaseBallGameModelImpl;
import baseball.view.BaseBallGameView;
import baseball.view.BaseBallGameViewImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGameModel model = new BaseBallGameModelImpl();
        BaseBallGameView view = new BaseBallGameViewImpl();
        BaseBallGameController controller = new BaseBallGameControllerImpl(model,view);
        controller.gameStart();
    }
}
