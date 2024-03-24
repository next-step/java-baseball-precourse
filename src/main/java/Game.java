import controller.GameController;
import model.GameModel;
import view.GameView;

public class Game {

    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);

        controller.play();
    }
}
