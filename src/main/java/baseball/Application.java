package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballModel;
import baseball.model.GameStatus;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        BaseballModel model = new BaseballModel();
        startGame(baseballController, model);
    }

    private static void startGame(BaseballController baseballController, BaseballModel model) {
        while (model.getGameStatus() != GameStatus.GAME_OVER) {
            ModelAndView gameMV = baseballController.startStage(model, 3);
            playStage(baseballController, gameMV);
            continueGame(baseballController, gameMV);
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

    private static void continueGame(BaseballController baseballController, ModelAndView gameMV) {
        BaseballModel model = (BaseballModel) gameMV.getModel();
        while (model.getGameStatus() == GameStatus.STAGE_END){
            String console = Console.readLine();
            gameMV = baseballController.continueGame(model, console);
            gameMV.getView().print();
        }
    }
}
