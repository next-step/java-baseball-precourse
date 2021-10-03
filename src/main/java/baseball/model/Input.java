package baseball.model;

import java.util.Set;

public class Input extends Number {

	private Status status;

	private enum Status {
		STRIKE, BALL
	}

	public Input(int index, int value) {
		super(index, value);
	}

	public void hit(Set<Target> targets) {
		for (Target target : targets) {
			hit(target);
		}
	}

	private void hit(Target target) {
		if (this.equals(target) && this.on(target)) {
			status = Status.STRIKE;
		} else if (this.equals(target) && !this.on(target)) {
			status = Status.BALL;
		}
	}

	public boolean isStrike() {
		return status == Status.STRIKE;
	}

	public boolean isBall() {
		return status == Status.BALL;
	}
}
