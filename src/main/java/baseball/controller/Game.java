package baseball.controller;

import baseball.domain.Command;
import baseball.domain.Digits;
import baseball.domain.Score;
import baseball.view.Input;
import baseball.view.Output;

public class Game {
    private final Digits digits;

    public Game() {
        this.digits = Digits.generate();
    }

    public void play() {
        String input = Input.scanDigits();
        Digits inputDigits = Digits.parse(input);
        Score score = digits.match(inputDigits);
        Output.print(score.yield());
        if (score.isDone()) {
            Command command = Command.of(Input.scanCommand());
            replay(command.isReplay());
            return;
        }
        play();
    }

    private void replay(boolean doesReplay) {
        if (doesReplay) {
            Game game = new Game();
            game.play();
        }
    }
}
