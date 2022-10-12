package study.baseball;

import study.BallStatus;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNumber ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = new BallNumber(ballNo);
    }

    public BallStatus play(Ball ball) {
        // 내부 필드가 모두 동일한 객체면 재정의된 equals() 함수로 동일한 값으로 판단된다.
        if (this.ballNo.equals(ball.ballNo) && this.position == ball.position) {
            return BallStatus.STRIKE;
        }
        // 필드에 직접접근하지 말고 (ball.ballNo) 행위를 구현하는 메소드를 생성하여 사용하는 버릇을 들이자
        if (ball.matchBallNo(ballNo.getNo())) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo.equals(new BallNumber(ballNo));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
