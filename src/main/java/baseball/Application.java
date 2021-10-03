package baseball;

import baseball.controller.BaseballController;
import baseball.view.CompareResultShowView;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        BaseballController controller = new BaseballController(new CompareResultShowView(), new InputView());
        controller.play();
    }
}
