package baseball.controller;

import baseball.model.Baseball;
import baseball.view.BaseballView;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class BaseballController {
    private Baseball model;
    private BaseballView view;

    public BaseballController(Baseball model, BaseballView view) {
        this.model = model;
        this.view = view;
    }

    public void setComputerNum() {
        model.setComputerNum();
    }

    public void setPlayerNum() {
        model.setPlayerNum(view.inputPlayerNum());
    }

    public void showResult() {
        view.printResult(model.returnResult());
    }

    public boolean playBaseball() {
        boolean game = true;

        this.setPlayerNum();
        model.setStrikeAndBall();
        this.showResult();

        //3 strike
        if(model.getStrike() == 3) {
            game = false;
        }
        return game;
    }

    public boolean keepGoingOrNot() {
        boolean play = true;

        if(view.endGameOrNot().equals("2")) {
            play = false;
        }

        return play;
    }
}
