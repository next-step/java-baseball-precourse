package baseball.model;

import java.util.Collections;
import java.util.List;

public class BallCount {
	private static final int COUNT_SIZE = 3;

	private final List<BallStatus> status;

	private BallCount(List<BallStatus> status) {
		validate(status);
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

	public boolean isNothing() {
		return Collections.frequency(status, BallStatus.NOTHING) == COUNT_SIZE;
	}

	private void validate(List<BallStatus> status) {
		if (status.size() != COUNT_SIZE) {
			throw new IllegalArgumentException("볼 카운트의 개수는 3개여야 합니다.");
		}
	}
}
