package baseball.config;

import baseball.controller.BaseballGameController;
import baseball.service.BaseballGameService;

public class AppConfig {

    private AppConfig() {
    }

    public static BaseballGameService baseballGameService() {
        return new BaseballGameService();
    }

    public static BaseballGameController baseballGameController() {
        return new BaseballGameController(baseballGameService());
    }
}
