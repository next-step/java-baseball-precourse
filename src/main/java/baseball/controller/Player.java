package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.GameResult;
import baseball.util.ParseUtils;

public class Player {

	private final Balls playerBalls;

	/**
	 * 객체 생성과 동시에 stringBalls 를 통해 멤버변수인 playerBalls 객체를 생성한다.
	 *
	 * @param stringBalls 1-9 사이의 숫자를 포함하는 길이가 3인 문자열 | 예시) 123,456,678
	 */
	public Player(String stringBalls) {
		playerBalls = new Balls(ParseUtils.toIntList(stringBalls));
	}

	public GameResult play(Computer computer) {
		return computer.play(playerBalls);
	}
}
