package baseball.domain;

import nextstep.utils.Console;

public class Player {

	private Numbers answer;


	public void inputAnswer() {
		String numberStr = Console.readLine();
		this.answer = new Numbers(numberStr);
	}

	public Numbers getAnswer() {
		return this.answer;
	}
}
