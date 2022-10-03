package baseball.model.player;

import static baseball.Application.util;

public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        this.inputNumber = util.makeRandomNumberInString();
    }
}
