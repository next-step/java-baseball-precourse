package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("공 비교 테스트")
public class BallTest {

	@ParameterizedTest
	@MethodSource("provideBalls")
	@DisplayName("볼, 스트라이크 확인")
	void ball(Ball ball, BallStatus ballStatus) {
		Ball answer = new Ball(1, 0);
		assertThat(answer.compare(ball)).isEqualTo(ballStatus);
	}

	private static Stream<Arguments> provideBalls() {
		return Stream.of(
			Arguments.of(new Ball(2, 0), BallStatus.NOTHING),
			Arguments.of(new Ball(1, 1), BallStatus.BALL),
			Arguments.of(new Ball(1, 2), BallStatus.BALL),
			Arguments.of(new Ball(1, 0), BallStatus.STRIKE),
			Arguments.of(new Ball(3, 0), BallStatus.NOTHING));
	}

}
