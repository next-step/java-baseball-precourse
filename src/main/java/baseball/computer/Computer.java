package baseball.computer;

import baseball.game.BaseBall;
import baseball.game.Games;

public class Computer {

    private final ScoreBag scoreBag;
    private final Games games = new BaseBall();

    public Computer() {
        scoreBag = new ScoreBag();
    }

    public boolean check(int[] inputs) {
        ScoreBag inputScores = ScoreBag.makeScoreBag(inputs);
        return check(inputScores);
    }

    private boolean check(ScoreBag scoreBag) {
        return games.play(this.scoreBag, scoreBag);
    }
}
