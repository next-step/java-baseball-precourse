package service;

import java.util.List;

import domain.Ball;
import domain.Game;

public class BaseballService {

	public Game compare(List<Ball> balls, List<Ball> inputs) {

		Game game = new Game();

		for (Ball ball : balls) {

			for (Ball input : inputs) {
				game.record(ball.compare(input));
			}
		}
		return game;
	}

}
