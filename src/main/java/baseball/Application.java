package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballModel;
import baseball.model.GameStatus;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        while (true) {
            ModelAndView gameMV = baseballController.startStage(3);
            playStage(baseballController, gameMV);
            break;
        }
    }

    private static void playStage(BaseballController baseballController, ModelAndView gameMV) {
        BaseballModel model = (BaseballModel) gameMV.getModel();
        gameMV.getView().print();
        while (model.getGameStatus() != GameStatus.STAGE_END) {
            gameMV = baseballController.challenge(model, Console.readLine());
            model = (BaseballModel) gameMV.getModel();
            gameMV.getView().print();
        }
    }
}
