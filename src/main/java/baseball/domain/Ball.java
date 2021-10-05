package baseball.domain;

public class Ball implements Check {
	private int ball;

	private Ball() {
		ball = 0;
	}

	public static Ball init() {
		return new Ball();
	}

	@Override
	public int value() {
		return this.ball;
	}

	@Override
	public void add() {
		this.ball++;
	}
}
