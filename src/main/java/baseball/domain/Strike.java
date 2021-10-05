package baseball.domain;

public class Strike implements Check {
	private static int strike;

	private Strike() {
		strike = INIT_VALUE;
	}

	public static Strike init() {
		return new Strike();
	}

	@Override
	public int value() {
		return strike;
	}

	@Override
	public void add() {
		strike++;
	}

	public boolean isThreeStrike() {
		return (strike == 3);
	}
}
