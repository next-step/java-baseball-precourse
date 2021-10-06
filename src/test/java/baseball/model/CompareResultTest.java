package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompareResultTest {
	@Test
	void update_테스트() {
		// given
		CompareResult compareResult = new CompareResult(3);
		int i = 0;
		int answerIndex = 0;

		// when
		compareResult.update(i, answerIndex);

		// then
		Assertions.assertThat(compareResult.getBall()).isZero();
		Assertions.assertThat(compareResult.getStrike()).isEqualTo(1);
		Assertions.assertThat(compareResult.isNothing()).isFalse();
	}

	void update_무시_테스트() {
		// given
		CompareResult compareResult = new CompareResult(3);
		int i = 0;
		int answerIndex = -1;

		// when
		compareResult.update(i, answerIndex);

		// then
		Assertions.assertThat(compareResult.isNothing()).isTrue();
	}

	@Test
	void isAnswer_테스트() {
		// given
		CompareResult compareResult = new CompareResult(3);
		int i = 0;
		int answerIndex = 0;

		// when
		compareResult.update(i, answerIndex);
		compareResult.update(i, answerIndex);
		compareResult.update(i, answerIndex);

		// then
		Assertions.assertThat(compareResult.getStrike()).isEqualTo(3);
		Assertions.assertThat(compareResult.isAnswer()).isTrue();
	}

	@Test
	void isNothing_테스트() {
		// given
		CompareResult compareResult1 = new CompareResult(3);
		CompareResult compareResult2 = new CompareResult(3);

		// when
		compareResult2.update(0, 0);

		// then
		Assertions.assertThat(compareResult1.isNothing()).isTrue();
		Assertions.assertThat(compareResult2.isNothing()).isFalse();
	}

}
