package baseball.domain.player;

import baseball.domain.ball.Balls;

public interface BallGeneratePolicy {
    Balls generate();
}
