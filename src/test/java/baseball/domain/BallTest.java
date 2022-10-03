package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.code.BallCountType;

@DisplayName("Ball 테스트")
class BallTest {

	private Ball computerBall;
	private Ball strikeBall;
	private Ball ballBall;
	private Ball nothingBall;

	@BeforeEach
	public void setUp() {
		computerBall = new Ball.Builder()
			.position(0)
			.value(1)
			.build();

		strikeBall = new Ball.Builder()
			.position(0)
			.value(1)
			.build();

		ballBall = new Ball.Builder()
			.position(1)
			.value(1)
			.build();

		nothingBall = new Ball.Builder()
			.value(2)
			.build();
	}

	@Test
	@DisplayName("Ball 생성 확인")
	void createBall() {
		// then
		assertAll(
			() -> assertThat(computerBall).isNotNull(),
			() -> assertThat(computerBall).isInstanceOf(Ball.class),
			() -> assertThat(computerBall.getPosition()).isEqualTo(0),
			() -> assertThat(computerBall.getValue()).isEqualTo(1)
		);
	}

	@Test
	@DisplayName("같은 수가 같은 위치에 존재할 때 스트라이크인지 확인")
	void checkStrikeBall() {
		// given // when
		Boolean result = computerBall.isStrike(strikeBall);

		// then
		assertAll(
			() -> assertThat(result).isEqualTo(true)
		);
	}

	@Test
	@DisplayName("같은 수가 다른 위치에 존재할 때 볼인지 확인")
	void checkBallBall() {
		// given // when
		Boolean result = computerBall.isBall(ballBall);

		// then
		assertAll(
			() -> assertThat(result).isEqualTo(true)
		);
	}

	@Test
	@DisplayName("Strike, Ball, Nothing 을 정상적으로 반환하는지 확인")
	void checkBallCountType() {
		// then
		assertAll(
			() -> assertThat(computerBall.checkBallCountType(strikeBall)).isEqualTo(BallCountType.STRIKE),
			() -> assertThat(computerBall.checkBallCountType(ballBall)).isEqualTo(BallCountType.BALL),
			() -> assertThat(computerBall.checkBallCountType(nothingBall)).isEqualTo(BallCountType.NOTHING)
		);
	}
}
