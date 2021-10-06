package baseball.controller;

import baseball.ModelAndView;
import baseball.model.BaseballModel;
import baseball.view.BaseballContinueView;
import baseball.view.BaseballExceptionView;
import baseball.view.BaseballPlayView;
import baseball.view.BaseballResultView;

public class BaseballController {

    public ModelAndView startStage(BaseballModel model, final int size) {
        model.startStage(size);
        return new ModelAndView(model, new BaseballPlayView());
    }

    public ModelAndView challenge(BaseballModel model, String answer) {
        try {
            model.challenge(answer);
        }catch (IllegalArgumentException e){
            return new ModelAndView(model, new BaseballExceptionView(model, e));
        }
        return new ModelAndView(model, new BaseballResultView(model));
    }

    public ModelAndView continueGame(BaseballModel model, String continueAnswer) {
        try {
            model.continueGame(continueAnswer);
        }catch (IllegalArgumentException e){
            return new ModelAndView(model, new BaseballExceptionView(model, e));
        }
        return new ModelAndView(model, new BaseballContinueView(model));
    }
}
