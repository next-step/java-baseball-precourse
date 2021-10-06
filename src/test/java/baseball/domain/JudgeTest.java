package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgeTest {

	@DisplayName("123과 132를 비교했을 때 1Strike, 2Ball, 낫싱 false인지 확인")
	@Test
	void judge_test() {
		Judge judge = new Judge();
		Set<Ball> ballNumbers = new LinkedHashSet<>();
		ballNumbers.add(Ball.of(1));
		ballNumbers.add(Ball.of(2));
		ballNumbers.add(Ball.of(3));

		BallNumbers computerNumber = BallNumbers.fromSet(ballNumbers);
		BallNumbers userNumber = BallNumbers.of("132");
		judge.countContainNumbers(computerNumber, userNumber);

		assertThat(judge.strikeCount()).isEqualTo(1);
		assertThat(judge.ballCount()).isEqualTo(2);
		assertThat(judge.isNothing()).isFalse();
	}
}
