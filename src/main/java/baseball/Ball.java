package baseball;

public class Ball {

	private int number;
	private int position;

	public Ball(int number, int position) {
		this.number = number;
		this.position = position;
	}

	public BallStatus match(Ball userBall) {
		if (this.equals(userBall)) {
			return BallStatus.STRIKE;
		}

		if (this.matchNumber(userBall)) {
			return BallStatus.BALL;
		}

		return BallStatus.NOTHING;
	}

	private boolean matchNumber(Ball userBall) {
		return this.number == userBall.number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.number;
		result = prime * result + this.position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Ball other = (Ball)obj;
		if (this.number != other.number) {
			return false;
		}
		if (this.position != other.position) {
			return false;
		}
		return true;
	}

}
