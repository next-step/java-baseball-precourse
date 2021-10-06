package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Score;
import baseball.view.GameView;

public class GameController {

    private static final String RESUME = "1";
    private static final String QUIT = "2";

    private final GameView view;
    private final Game game;
    private boolean key;

    public GameController(GameView view, Game game) {
        this.view = view;
        this.game = game;
        this.key = true;
    }

    public void start() {
        while (key) {
            view.showInputMessage();
            Score score = game.input(view.getInput());
            view.showScoreMessage(score);
            checkCorrect(score);
        }
    }

    private void checkCorrect(Score score) {
        if (score.isCorrect()) {
            view.showEndMessage();
            key = isResume();
        }
    }

    private boolean isResume() {
        view.showResumeMessage();
        String number = view.getResume();
        if (number == RESUME) {
            game.update();
            return true;
        }
        if (number == QUIT) {
            return false;
        }
        view.showResumeError();
        return isResume();
    };
}
