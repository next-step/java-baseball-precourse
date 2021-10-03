package service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.Ball;
import domain.BallStatus;
import domain.GameStatus;

class BaseballServiceTest {

	private List<Ball> balls;
	private Ball ball;
	private BaseballService baseballService;

	@BeforeEach
	void setUp() {
		baseballService = new BaseballService();
		balls = Arrays.asList(
			new Ball(1, 0),
			new Ball(2, 1),
			new Ball(3, 2));

		ball = new Ball(1, 0);
	}

	@ParameterizedTest
	@MethodSource("provideBalls")
	@DisplayName("각각의 공을 비교하여 결과값 확인")
	void compareBall(Ball input, BallStatus ballStatus) {
		assertThat(ball.compare(input)).isEqualTo(ballStatus);
	}

	@ParameterizedTest
	@MethodSource("provideBallList")
	@DisplayName("모든 공을 비교하여 게임 결과 확인")
	void compareBallList(List<Ball> input, GameStatus gameStatus) {
		assertThat(baseballService.compare(balls, input).getGameStatus()).isEqualTo(gameStatus);
	}

	private static Stream<Arguments> provideBalls() {
		return Stream.of(
			Arguments.of(new Ball(1, 0), BallStatus.STRIKE),
			Arguments.of(new Ball(1, 1), BallStatus.BALL),
			Arguments.of(new Ball(4, 0), BallStatus.NOTHING));
	}

	private static Stream<Arguments> provideBallList() {
		return Stream.of(
			Arguments.of(Arrays.asList(new Ball(1, 0), new Ball(2, 1), new Ball(3, 2)), GameStatus.CORRECT),
			Arguments.of(Arrays.asList(new Ball(3, 0), new Ball(2, 1), new Ball(1, 2)), GameStatus.INCORRECT),
			Arguments.of(Arrays.asList(new Ball(4, 0), new Ball(5, 1), new Ball(6, 2)), GameStatus.NOTHING));
	}

	private class TestBaseballService extends BaseballService {

	}
}
