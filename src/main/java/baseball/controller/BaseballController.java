package baseball.controller;

import baseball.ModelAndView;
import baseball.model.BaseballModel;
import baseball.view.BaseballPlayView;

public class BaseballController {

    public ModelAndView startStage(final int size) {
        return new ModelAndView(new BaseballModel(size), new BaseballPlayView());
    }
}
