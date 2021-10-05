package baseball;

import baseball.controller.BaseballGameFlowController;

public class Application {
    public static void main(String[] args) {
        BaseballGameFlowController baseBallGameFlowController = new BaseballGameFlowController();

        while(!baseBallGameFlowController.isFinished()){
            baseBallGameFlowController.start();
            baseBallGameFlowController.checkRestart();
        }
    }
}
