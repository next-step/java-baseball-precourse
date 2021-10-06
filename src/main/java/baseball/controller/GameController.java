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
            view.showResumeMessage();
            String number = view.getResume();
            key = checkResume(number);
        }
    }

    private boolean checkResume(String number) {
        if (number == RESUME) {
            game.update();
            return true;
        }
        if (number == QUIT) {
            return false;
        }
        System.err.println("[ERROR] 1과 2중 하나의 숫자를 선택해주세요.");
        return checkResume(number);
    };
}
