package baseball;

import baseball.model.BaseballNumber;
import nextstep.utils.Randoms;
import nextstep.utils.Validation;
import baseball.model.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGame.createGame();
        baseballGame.getComputer().getNumber();
    }
}
