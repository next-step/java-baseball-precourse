package baseball;

import baseball.domain.BaseballController;
import baseball.domain.BaseballNumberGenerator;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        do {
            List<Integer> computerBaseballNumbers = BaseballNumberGenerator.generateBaseballNumbers();
            BaseballController.startBaseballGame(computerBaseballNumbers);
        } while(BaseballController.isNewGame());
    }
}





