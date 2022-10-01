package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumberTest {

	@Test
	@DisplayName("같은 값을 가진 BallNumber 객체는 같은 객체이다.")
	void equalsTest() {
		// given
		BallNumber ballNumber1 = new BallNumber(1);
		BallNumber ballNumber2 = new BallNumber(1);
		// when
		// then
		Assertions.assertThat(ballNumber1).isEqualTo(ballNumber2);
	}

}