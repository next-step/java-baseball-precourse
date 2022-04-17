package baseball;

import baseball.config.AppConfig;
import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        BaseballGameController controller = appConfig.baseballGameController();
        controller.execute();
    }
}
