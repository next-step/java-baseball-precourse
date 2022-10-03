package baseball;

import baseball.config.AppConfig;
import baseball.controller.BaseballController;

public class Application {

    public static void main(String[] args) {
        BaseballController controller = AppConfig.getController();
        controller.createBaseball();
        boolean complete;
        do {
            controller.playBaseball();
            controller.result();
            complete = controller.isComplete();
        } while (!complete);
    }
}
