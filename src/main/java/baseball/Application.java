package baseball;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = false;
        do {
            GameController gameController = new GameController();
            gameController.playGame();

            isContinue = gameController.askContinue();
        } while (isContinue);
    }
}
