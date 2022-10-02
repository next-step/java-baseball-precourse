package baseball.game;

import baseball.score.Score;
import baseball.tool.Baseball;

public class BaseballPlay implements Play {
    private final Baseball computer;
    private final Baseball person;
    private final Score score;

    BaseballPlay(Baseball computer, Baseball person, Score score) {
        this.computer = computer;
        this.person = person;
        this.score = score;
    }


    @Override
    public void start() {
    }

    @Override
    public void stop() {

    }
}
