package baseball.player;

import baseball.ball.Ball;

public interface Player<T> {

    Ball createBall(T t);
    
}
