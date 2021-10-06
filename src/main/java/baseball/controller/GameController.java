package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Score;
import baseball.view.GameView;

import java.util.NoSuchElementException;

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
            String input = view.showInputMessage();
            Score score = null;
            try {
                score = game.input(input);
                view.showScoreMessage(score);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }
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
        if (number.equals(RESUME)) {
            game.update();
            return true;
        }
        if (number.equals(QUIT)) {
            return false;
        }
        view.showResumeError();
        return isResume();
    };
}
