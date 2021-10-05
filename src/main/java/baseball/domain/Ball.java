package baseball.domain;

public class Ball implements Check {
	private int ball;

	private Ball() {
		ball = Check.INIT_VALUE;
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
