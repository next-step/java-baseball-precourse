package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsTest {

	private Balls computerBalls;

	@BeforeEach
	void setUp() {
		computerBalls = new Balls(Arrays.asList(1, 2, 3));
	}

	@DisplayName("balls 객체를 생성한다. 정확하게 3개의 공을 갖고있어야 한다.")
	@Test
	void create() {
		// given
		final List<Integer> ballList = Arrays.asList(1, 2, 3);

		// when then
		assertDoesNotThrow(() -> new Balls(ballList));
	}

	@DisplayName("balls 객체를 생성한다. 정확하게 3개의 공을 갖고있어야 한다, 테스트에서는 2개만 갖고있에 예외를 발생시킨다.")
	@Test
	void create_fail_test() {
		// given
		final List<Integer> ballList = Arrays.asList(1, 2);

		// when then
		assertThatThrownBy(() -> new Balls(ballList))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 숫자야구 게임을 하기위해서는 3개의 공이 필요합니다.");
	}

	@DisplayName("3개의 ball과 한개의 공을 테스트한다.")
	@ParameterizedTest(name = "{displayName} / 컴퓨터: 123 vs 플레이어 공 숫자: {0} 위치: {1} / 결과: Nothing")
	@CsvSource(value = {"4:1", "5:2", "6:3"}, delimiter = ':')
	void nothing(int number, int position) {
		// given
		final Ball playerBall = new Ball(number, position);

		// when then
		assertEquals(GameStatus.NOTHING, computerBalls.play(playerBall));
	}

	@DisplayName("3개의 ball과 한개의 공을 테스트한다.")
	@ParameterizedTest(name = "{displayName} / 컴퓨터: 123 vs 플레이어 공 숫자: {0} 위치: {1} / 결과: Ball")
	@CsvSource(value = {"1:2", "2:3", "3:1"}, delimiter = ':')
	void ball(int number, int position) {
		// given
		final Ball playerBall = new Ball(number, position);

		// when then
		assertEquals(GameStatus.BALL, computerBalls.play(playerBall));
	}

	@DisplayName("3개의 ball과 한개의 공을 테스트한다.")
	@ParameterizedTest(name = "{displayName} / 컴퓨터: 123 vs 플레이어 공 숫자: {0} 위치: {1} / 결과: Strike")
	@CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
	void strike(int number, int position) {
		// given
		final Ball playerBall = new Ball(number, position);

		// when then
		assertEquals(GameStatus.STRIKE, computerBalls.play(playerBall));
	}

	@DisplayName("컴퓨터의 숫자야구(123) 과 3개의 Ball(Balls) 테스트하여 0strike 0ball 을 반환하는 케이스를 테스트한다.")
	@Test
	void strike0_and_ball0() {
		// given
		final List<Integer> ballList = Arrays.asList(4, 5, 6);

		final Balls playerBalls = new Balls(ballList);

		// when then
		final GameResult play = computerBalls.play(playerBalls);
		assertEquals(new GameResult(0, 0), play);
	}

	@DisplayName("3개의 ball과 3개의 ball을 테스트한다.")
	@ParameterizedTest(name = "{displayName} / 컴퓨터: 123 vs 플레이어 공 숫자: {0}{1}{2} / 결과: 1스트라이크 1볼")
	@CsvSource(value = {"1:3:5", "3:2:5", "9:2:1", "2:5:3"}, delimiter = ':')
	void strike1_and_ball1(int first, int second, int third) {
		// given
		final List<Integer> ballList = Arrays.asList(first, second, third);

		final Balls playerBalls = new Balls(ballList);

		// when then
		final GameResult play = computerBalls.play(playerBalls);
		assertEquals(new GameResult(1, 1), play);
	}

	@DisplayName("컴퓨터의 숫자야구(123) 과 3개의 Ball(Balls) 테스트하여 3strike 를 반환하는 케이스를 테스트한다.")
	@Test
	void strike3_ball0() {
		// given
		final List<Integer> ballList = Arrays.asList(1, 2, 3);

		final Balls playerBalls = new Balls(ballList);

		// when then
		final GameResult play = computerBalls.play(playerBalls);
		assertEquals(new GameResult(3, 0), play);
	}
}
