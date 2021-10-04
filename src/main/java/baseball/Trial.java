package baseball;

import java.util.List;

public class Trial {
    private BallCollection ballCollection;

    public Trial(List<Integer> ballNumbers) {
        this.ballCollection = new BallCollection();

        for (int i = 0; i < ballNumbers.size(); i++) {
            this.ballCollection.add(new Ball(ballNumbers.get(i), i));
        }
    }

    public PlayResult play(Trial trial) {
        PlayResult playResult = new PlayResult();

        for (Ball myBall : this.ballCollection) {
            playResult.add(trial.play(myBall));
        }

        return playResult;
    }

    private MATCH_RESULT play(Ball counterBall) {
        return this.ballCollection.match(counterBall);
    }
}
