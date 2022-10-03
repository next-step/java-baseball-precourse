package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallsTest {

	private Balls computer;

	@BeforeEach
	void setUp() {
		computer = new Balls(Arrays.asList(7, 3, 6));
	}

	@Test
	void play_strike() {
		Ball userBall = new Ball(1, 7);
		BallStatus status = computer.play(userBall);
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}

	@Test
	void play_ball() {
		Ball userBall = new Ball(3, 7);
		BallStatus status = computer.play(userBall);
		assertThat(status).isEqualTo(BallStatus.BALL);
	}

	@Test
	void play_nothing() {
		Ball userBall = new Ball(3, 9);
		BallStatus status = computer.play(userBall);
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}

	@Test
	void play_3strike() {
		List<Integer> userBall = Arrays.asList(7, 3, 6);
		PlayResult result = computer.play(userBall);
		assertThat(result.getStrike()).isEqualTo(3);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	void play_2strike() {
		List<Integer> userBall = Arrays.asList(7, 1, 6);
		PlayResult result = computer.play(userBall);
		assertThat(result.getStrike()).isEqualTo(2);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	void play_1strike() {
		List<Integer> userBall = Arrays.asList(7, 9, 1);
		PlayResult result = computer.play(userBall);
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(0);
	}

	@Test
	void play_3ball() {
		List<Integer> userBall = Arrays.asList(3, 6, 7);
		PlayResult result = computer.play(userBall);
		assertThat(result.getBall()).isEqualTo(3);
		assertThat(result.getStrike()).isEqualTo(0);
	}

	@Test
	void play_2ball() {
		List<Integer> userBall = Arrays.asList(1, 6, 7);
		PlayResult result = computer.play(userBall);
		assertThat(result.getBall()).isEqualTo(2);
		assertThat(result.getStrike()).isEqualTo(0);
	}

	@Test
	void play_1ball() {
		List<Integer> userBall = Arrays.asList(1, 9, 7);
		PlayResult result = computer.play(userBall);
		assertThat(result.getBall()).isEqualTo(1);
		assertThat(result.getStrike()).isEqualTo(0);
	}

	@Test
	void play_1strike_2ball() {
		List<Integer> userBall = Arrays.asList(7, 6, 3);
		PlayResult result = computer.play(userBall);
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(2);
	}

	@Test
	void play_1strike_1ball() {
		List<Integer> userBall = Arrays.asList(7, 6, 1);
		PlayResult result = computer.play(userBall);
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(1);
	}

	@Test
	void play_all_nothing() {
		List<Integer> userBall = Arrays.asList(9, 2, 5);
		PlayResult result = computer.play(userBall);
		assertThat(result.getStrike()).isEqualTo(0);
		assertThat(result.getBall()).isEqualTo(0);
	}
}