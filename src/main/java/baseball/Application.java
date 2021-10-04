package baseball;

import baseball.controller.GameController;
import baseball.generator.InputGenerator;
import baseball.generator.NumberGenerator;
import baseball.validator.InputValidator;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // 숫자 야구 게임 시작
        final GameController gameController = new GameController();
        gameController.baseballGame();
    }
}
