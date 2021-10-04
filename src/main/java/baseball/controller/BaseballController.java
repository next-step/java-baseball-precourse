package baseball.controller;

import baseball.model.Baseball;
import baseball.view.BaseballView;

public class BaseballController {
    private Baseball model;
    private BaseballView view;

    public BaseballController(Baseball model, BaseballView view) {
        this.model = model;
        this.view = view;
    }

    public void setComputerNum() {
       model.setComputerNum(model.selectThreeNums());
       //System.out.println(model.getComputerNum());
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
        if(!model.checkPlayerNum()){
            view.printInvalidInput();
            return true;
        }

        model.setStrikeAndBall();
        this.showResult();

        //3 strike
        if(model.getStrike() == 3) {
            game = false;
            printEndGameMsg();
        }
        return game;
    }

    public void printEndGameMsg() {
        view.printEndGameMsg1();
        view.printEndGameMsg2();
    }

    public void printInvalidEndInput() {
        view.printInvalidInput();
        view.printEndGameMsg2();
    }
    public int keepGoingOrNot() {
        String game = view.endGameOrNot();
        if(!(game.equals("1") || game.equals("2"))) {
            printInvalidEndInput();
            return -1;
        }

        return Integer.parseInt(game);
    }
}
