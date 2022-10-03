package baseball.game;

public class GameManager {

    private Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public void run() {
        game.init();
        while (!game.isRunning()) {
            game.start();
        }
        boolean isFinish = game.finish();
        if (isFinish) {
            run();
        }
    }
}
