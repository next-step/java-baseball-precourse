import controller.BaseballGameController;
import model.BaseballGameModel;
import view.BaseballGameView;

public class BaseballGameApplication {
    public static void main(String[] args) {
        BaseballGameModel model = new BaseballGameModel();
        BaseballGameView view = new BaseballGameView();
        BaseballGameController controller = new BaseballGameController(model, view);

        controller.playGame();
    }
}
