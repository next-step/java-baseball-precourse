package baseball.zone.domain;

import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zone {

    private final List<Ball> zoneBalls = new ArrayList<>();

    public void generate() {
        this.zoneBalls.clear();
        while (this.zoneBalls.size() < 3) {
            BigDecimal zoneNumber = BigDecimal.valueOf(Randoms.pickNumberInRange(1, 9));
            addZone(zoneNumber);
        }
    }

    public void addZone(BigDecimal zoneNumber) {
        if (this.zoneBalls.size() > 2) {
            return;
        }
        if (!this.zoneNumbers().contains(new BallNumber(zoneNumber))) {
            this.zoneBalls.add(new Ball(new BallNumber(zoneNumber), new BallLocation(BigDecimal.valueOf(this.zoneBalls.size() + 1))));
        }
    }

    public List<BallNumber> zoneNumbers() {
        List<BallNumber> zoneNumbers = new ArrayList<>();
        for (Ball zoneBall : this.zoneBalls) {
            zoneNumbers.add(zoneBall.ballNumber());
        }
        return Collections.unmodifiableList(zoneNumbers);
    }

    public List<Ball> zones() {
        return this.zoneBalls;
    }

    public boolean isContainBall(Ball ball) {
        return this.zoneBalls.contains(ball);
    }

    public boolean isContainBallNumber(BallNumber ballNumber) {
        return this.zoneNumbers().contains(ballNumber);
    }

}
