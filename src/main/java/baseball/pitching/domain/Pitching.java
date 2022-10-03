package baseball.pitching.domain;

import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;

import java.util.ArrayList;
import java.util.List;

public class Pitching {

    private final List<Ball> pitchingBalls = new ArrayList<>();

    public Pitching() {
    }

    public List<Ball> pitchingBalls() {
        return this.pitchingBalls;
    }

    public void add(Ball pitchingBall) {
        validMaxPitchingCount();
        validateDuplicatePitchingNumber(pitchingBall.ballNumber());
        validateDuplicatePitchingLocation(pitchingBall.ballLocation());
        this.pitchingBalls.add(pitchingBall);
    }

    private void validMaxPitchingCount() {
        if (this.pitchingBalls.size() >= 3) {
            throw new IllegalArgumentException("투구 영역에 4개 이상의 투구를 추가할 수 업습니다.");
        }
    }

    private void validateDuplicatePitchingNumber(BallNumber pitchingNumber) {
        if (containsNumber(pitchingNumber)) {
            throw new IllegalArgumentException("투구 숫자가 중복입니다.");
        }
    }

    private boolean containsNumber(BallNumber pitchingNumber) {
        for (Ball ball : this.pitchingBalls) {
            return ball.ballNumber().equals(pitchingNumber);
        }
        return false;
    }

    private boolean containsLocation(BallLocation pitchingLocation) {
        for (Ball ball : this.pitchingBalls) {
            return ball.ballLocation().equals(pitchingLocation);
        }
        return false;
    }

    private void validateDuplicatePitchingLocation(BallLocation addPitchingLocation) {
        if (containsLocation(addPitchingLocation)) {
            throw new IllegalArgumentException("투구 위치가 중복입니다.");
        }
    }

}
