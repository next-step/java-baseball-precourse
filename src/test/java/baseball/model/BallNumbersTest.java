package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumbersTest {

	BallNumbers ballNumbers;

	@BeforeEach
	void init() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		ballNumbers = BallNumbers.of(numbers);
	}

	@Test
	@DisplayName("Integer List 를 받아 BallNumber 를 가진 BallNumbers 객체를 생성한다.")
	void createBallNumbersTest() {
		// given
		// when
		// then
		assertThat(ballNumbers.getBallNumberList().get(1)).isInstanceOf(BallNumber.class);
	}

	@Test
	@DisplayName("BallNumbers 객체를 생성할 때 중복된 숫자가 있으면 IllegalArgumentException 발생")
	void createBallNumbersWithDuplicateNumberTest() {
		// given
		List<Integer> numbers = Arrays.asList(1, 2, 2);
		// when
		// then
		assertThatThrownBy(() -> BallNumbers.of(numbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 숫자가 있습니다.");
	}

	@Test
	@DisplayName("BallNumbers 의 인덱스를 통해 BallNumber 의 숫자를 가져올 수 있다.")
	void getNumberTest() {
		// given
		// when
		int firstNumber = ballNumbers.getNumber(0);
		int secondNumber = ballNumbers.getNumber(1);
		int thirdNumber = ballNumbers.getNumber(2);
		// then
		assertThat(firstNumber).isEqualTo(1);
		assertThat(secondNumber).isEqualTo(2);
		assertThat(thirdNumber).isEqualTo(3);
	}

	@Test
	@DisplayName("getNumberSize 메서드를 통해 BallNumbers 의 크기를 반환한다.")
	void getNumberSizeTest() {
		// given
		// when
		int numberSize = ballNumbers.getNumberSize();
		// then
		assertThat(numberSize).isEqualTo(3);
	}
}