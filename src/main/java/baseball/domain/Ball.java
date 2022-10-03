package baseball.domain;

import java.util.List;

public class Ball {
	private int number;
	private int position;

	public Ball(int number, int position) {
		this.number = number;
		this.position = position;
	}

	boolean isStrike(Ball otherBall) {
		return this.number == otherBall.number && this.position == otherBall.position;
	}

	boolean isBall(Ball otherBall) {
		return this.number == otherBall.number && this.position != otherBall.position;
	}

	public Status compareBall(List<Ball> board) {
		for(Ball computerBall : board) {
			if(isStrike(computerBall)) {
				return Status.STRIKE;
			}
			if(isBall(computerBall)) {
				return Status.BALL;
			}
		}
		return Status.NOTHING;
	}

}

