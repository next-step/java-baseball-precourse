package domain;

public class Ball {

	private int number;
	private int position;

	public Ball(int number, int position) {
		this.number = number;
		this.position = position;
	}

	public BallStatus compare(Ball ball) {
		if (this.number == ball.number && this.position == ball.position) {
			return BallStatus.STRIKE;
		} else if (this.number == ball.number && this.position != ball.position) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}
}
