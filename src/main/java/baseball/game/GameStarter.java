package baseball.game;

public class GameStarter {

    private final Game game;

    public GameStarter(Game game) {
        this.game = game;
    }

    public void start() {
        game.onRefresh();
        while (game.playable) {
            game.onPlay();
            game.onEnd();
        }
    }
}
