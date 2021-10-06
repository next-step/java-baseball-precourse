package baseball.model;

import java.util.List;

import baseball.enums.MATCH_RESULT;

public class PlayerState {
    private BallCollection ballCollection;

    public PlayerState(List<Integer> ballNumbers) {
        this.ballCollection = new BallCollection();

        for (int i = 0; i < ballNumbers.size(); i++) {
            this.ballCollection.add(new Ball(ballNumbers.get(i), i));
        }
    }

    public PlayResult play(PlayerState playerState) {
        PlayResult playResult = new PlayResult();

        for (Ball myBall : this.ballCollection) {
            playResult.add(playerState.play(myBall));
        }

        return playResult;
    }

    private MATCH_RESULT play(Ball counterBall) {
        return this.ballCollection.match(counterBall);
    }
}
