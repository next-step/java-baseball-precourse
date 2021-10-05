package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballModel;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        ModelAndView gameMV = baseballController.startStage(3);

        BaseballModel model = (BaseballModel) gameMV.getModel();
        System.out.println(model.getRandomNumber());
        gameMV.getView().print();
    }
}
