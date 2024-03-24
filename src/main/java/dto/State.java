package dto;

public class State {
	private int strike;
	private int ball;

	public State() {
		strike = 0;
		ball = 0;
	}

	public State(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	public void adjustState(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
