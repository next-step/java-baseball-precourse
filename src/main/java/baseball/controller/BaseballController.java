package baseball.controller;

import baseball.ModelAndView;
import baseball.model.BaseballModel;
import baseball.view.BaseballExceptionView;
import baseball.view.BaseballPlayView;
import baseball.view.BaseballResultView;

public class BaseballController {

    public ModelAndView startStage(final int size) {
        return new ModelAndView(new BaseballModel(size), new BaseballPlayView());
    }

    public ModelAndView challenge(BaseballModel model, String answer) {
        try {
            model.challenge(answer);
        }catch (IllegalArgumentException e){
            return new ModelAndView(model, new BaseballExceptionView(e));
        }
        return new ModelAndView(model, new BaseballResultView(model));
    }
}
