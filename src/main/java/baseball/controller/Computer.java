package baseball.controller;

import java.util.List;

import baseball.model.Balls;
import baseball.model.GameResult;

public class Computer {

	private final Balls computerBalls;

	/**
	 * 객체 생성과동시에 랜덤한 3개의 번호를 갖고있는 computerBalls 를 생성한다.
	 */
	public Computer(List<Integer> numbers) {
		computerBalls = new Balls(numbers);
	}

	public GameResult play(Balls playerBalls) {
		return playerBalls.play(computerBalls);
	}
}
