package baseball.domain;

public class Computer {
	private final BaseballNumber baseballNumber;

	public Computer() {
		this.baseballNumber = new BaseballNumber();
	}

	public BaseballNumber getBaseballNumber() {
		return this.baseballNumber;
	}
}
