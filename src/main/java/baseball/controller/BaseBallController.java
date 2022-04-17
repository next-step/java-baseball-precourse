package baseball.controller;

import baseball.dto.BaseballDTO;
import baseball.service.BaseBallService;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController() {
        this.baseBallService = new BaseBallService();
    }

    public void initAnswer() {
        baseBallService.initAnswer();
    }

    public BaseballDTO.ResResult submitAnswer(final String userAnswer) {
        return baseBallService.submitAnswer(userAnswer);
    }
}
