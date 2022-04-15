package baseball;

import baseball.constants.GameView;
import baseball.controllers.BaseballController;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BaseballGame {
    private BaseballController controller;
    private Map<GameView, Supplier<GameView>> routeEvaluator = new HashMap<>();

    public BaseballGame() {
        controller = new BaseballController();
        routeEvaluator.put(GameView.INPUT, () -> controller.inputView());
        routeEvaluator.put(GameView.COMPLETE_MENU, () -> controller.completeMenuView());
    }

    public void start() {
        GameView currentView = GameView.INPUT;
        while (currentView != GameView.BYE) {
            currentView = routeEvaluator.get(currentView).get();
        }
    }


}
