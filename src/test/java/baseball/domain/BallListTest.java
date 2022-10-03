package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Ball List 테스트")
class BallListTest {

	private BallList computerBallList;
	private BallList strikeBallList;
	private BallList ballBallList;

	@BeforeEach
	public void setUp() {
		computerBallList = new BallList(Arrays.asList(1, 2, 3));
		strikeBallList = new BallList(Arrays.asList(1, 2, 3));
		ballBallList = new BallList(Arrays.asList(2, 3, 4));
	}

	@ParameterizedTest(name = "생성한 Ball List에 position: {0}, value: {1} 인 Ball이 정상적으로 생성되었는지 확인")
	@CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
	void createBallList(int position, int value) {
		// then
		assertAll(
			() -> assertThat(computerBallList.getBallList()).isNotEmpty(),
			() -> assertThat(computerBallList).isInstanceOf(BallList.class),
			() -> assertThat(computerBallList.getBallList().get(position).getValue()).isEqualTo(value)
		);
	}

	@Test
	@DisplayName("정상적으로 스트라이크 개수를 판단하는지 확인")
	void checkStrikeBallCount() {
		// given // when
		Integer strikeCount = computerBallList.strikeBallCount(strikeBallList);

		// then
		assertAll(
			() -> assertThat(strikeCount).isNotNull(),
			() -> assertThat(strikeCount).isEqualTo(3)
		);
	}

	@Test
	@DisplayName("정상적으로 볼 개수를 판단하는지 확인")
	void checkBallBallCount() {
		// given // when
		Integer ballCount = computerBallList.ballBallCount(ballBallList);

		// then
		assertAll(
			() -> assertThat(ballCount).isNotNull(),
			() -> assertThat(ballCount).isEqualTo(2)
		);
	}

	@ParameterizedTest(name = "Ball List({0}, {1}, {2})를 입력하였을 때 정상적으로 볼 카운트를 수행하는지 확인")
	@MethodSource("generateData")
	void checkBallCount(int ball1, int ball2, int ball3, GameResult gameResult) {
		// given
		BallList userBallList = new BallList(Arrays.asList(ball1, ball2, ball3));

		// when
		GameResult result = computerBallList.ballCount(userBallList);

		// then
		assertAll(
			() -> assertThat(userBallList.getBallList()).isNotEmpty(),
			() -> assertThat(result.getStrike()).isEqualTo(gameResult.getStrike()),
			() -> assertThat(result.getBall()).isEqualTo(gameResult.getBall())
		);
	}

	static Stream<Arguments> generateData() {
		return Stream.of(
			Arguments.of(1, 2, 3, new GameResult.Builder().strike(3).ball(0).build()),
			Arguments.of(2, 3, 4, new GameResult.Builder().strike(0).ball(2).build()),
			Arguments.of(1, 3, 2, new GameResult.Builder().strike(1).ball(2).build()),
			Arguments.of(4, 5, 6, new GameResult.Builder().strike(0).ball(0).build())
		);
	}
}
