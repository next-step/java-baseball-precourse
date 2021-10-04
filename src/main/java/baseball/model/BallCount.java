package baseball.model;

import java.util.Collections;
import java.util.List;

public class BallCount {

	private List<BallStatus> status;

	private BallCount(List<BallStatus> status) {
		if (status.size() != 3) {
			throw new IllegalArgumentException("볼 카운트의 개수는 3개여야 합니다.");
		}

		this.status = status;
	}

	public static BallCount from(List<BallStatus> status) {
		return new BallCount(status);
	}

	public int countStrike() {
		return Collections.frequency(status, BallStatus.STRIKE);
	}

	public int countBall() {
		return Collections.frequency(status, BallStatus.BALL);
	}
}
