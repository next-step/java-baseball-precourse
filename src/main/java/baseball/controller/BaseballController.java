package baseball.controller;

import baseball.service.BaseballProcessService;
import baseball.service.impl.BaseballProcessServiceImpl;

public class BaseballController {

    public static void PlayBaseballGame() {

        BaseballProcessService baseballProcessService = BaseballProcessServiceImpl.getInstance();
        baseballProcessService.initGame();

    }
}
