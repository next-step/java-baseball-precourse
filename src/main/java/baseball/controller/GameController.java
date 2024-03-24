package baseball.controller;

import baseball.domain.GameCommand;

public interface GameController {

    void process(GameCommand status);
}
