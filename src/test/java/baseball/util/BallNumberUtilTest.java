package baseball.util;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.exception.InvalidBallNumberException;
import baseball.vo.BallNumberVo;

public class BallNumberUtilTest {
	@DisplayName("createSelectedNumberList 정상 동작 확인")
	@Test
	void createSelectedNumberList() {
		assertThat(BallNumberUtil.createBallNumber()).isNotNull();
	}

	@DisplayName("checkBallNumber 정상 동작 확인")
	@Test
	void checkBallNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		selectedNumber.setNumbers(numbers);
		assertThat(BallNumberUtil.checkBallNumber(selectedNumber)).isTrue();
	}

	@DisplayName("checkBallNumber 비정상 사이즈 체크")
	@Test
	void checkBallNumberInvalidSize() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		selectedNumber.setNumbers(numbers);

		assertThat(BallNumberUtil.checkBallNumber(selectedNumber)).isFalse();
	}

	@DisplayName("checkBallNumber 범위 외의 숫자")
	@Test
	void checkBallNumberInvalidNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(0);
		selectedNumber.setNumbers(numbers);

		assertThat(BallNumberUtil.checkBallNumber(selectedNumber)).isFalse();
	}

	@DisplayName("checkBallNumber 중복 숫자")
	@Test
	void checkBallNumberDuplicatNumber() {
		BallNumberVo selectedNumber = new BallNumberVo();

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(2);
		selectedNumber.setNumbers(numbers);

		assertThat(BallNumberUtil.checkBallNumber(selectedNumber)).isFalse();
	}

	@DisplayName("stringToBallNumber 정상 동작 확인")
	@Test
	void stringToBallNumber() throws InvalidBallNumberException {
		BallNumberVo ballNumber = BallNumberUtil.stringToBallNumber("123");
		assertThat(ballNumber).isNotNull();

		List<Integer> numbers = ballNumber.getNumbers();

		assertThat(numbers).isNotNull();
		assertThat(numbers.get(0)).isEqualTo(1);
		assertThat(numbers.get(1)).isEqualTo(2);
		assertThat(numbers.get(2)).isEqualTo(3);
	}

	@DisplayName("stringToBallNumber 비정상 사이즈 체크")
	@Test
	void stringToBallNumberInvalidSize() throws InvalidBallNumberException {
		assertThatThrownBy(() -> BallNumberUtil.stringToBallNumber("1234"))
			.isInstanceOf(InvalidBallNumberException.class);
	}

	@DisplayName("stringToBallNumber 범위 외의 숫자")
	@Test
	void stringToBallNumberInvalidNumber() throws InvalidBallNumberException {
		assertThatThrownBy(() -> BallNumberUtil.stringToBallNumber("120"))
			.isInstanceOf(InvalidBallNumberException.class);
	}

	@DisplayName("stringToBallNumber 중복 숫자")
	@Test
	void stringToBallNumberDuplicatNumbe() throws InvalidBallNumberException {
		assertThatThrownBy(() -> BallNumberUtil.stringToBallNumber("122"))
			.isInstanceOf(InvalidBallNumberException.class);
	}

	@DisplayName("getBallBetweenBallNumber 테스트")
	@Test
	void getBallBetweenBallNumber() {
		assertThatThrownBy(() -> BallNumberUtil.stringToBallNumber("122"))
			.isInstanceOf(InvalidBallNumberException.class);
	}

	@DisplayName("getStrikeBetweenBallNumber 테스트")
	@Test
	void getStrikeBetweenBallNumber() throws InvalidBallNumberException {
		BallNumberVo ballNumber1 = BallNumberUtil.stringToBallNumber("123");
		BallNumberVo ballNumber2 = BallNumberUtil.stringToBallNumber("456");

		assertThat(BallNumberUtil.getBallBetweenBallNumber(ballNumber1, ballNumber2)).isEqualTo(0);

		ballNumber1 = BallNumberUtil.stringToBallNumber("123");
		ballNumber2 = BallNumberUtil.stringToBallNumber("123");
		assertThat(BallNumberUtil.getBallBetweenBallNumber(ballNumber1, ballNumber2)).isEqualTo(0);

		ballNumber1 = BallNumberUtil.stringToBallNumber("123");
		ballNumber2 = BallNumberUtil.stringToBallNumber("452");
		assertThat(BallNumberUtil.getBallBetweenBallNumber(ballNumber1, ballNumber2)).isEqualTo(1);

		ballNumber1 = BallNumberUtil.stringToBallNumber("123");
		ballNumber2 = BallNumberUtil.stringToBallNumber("231");
		assertThat(BallNumberUtil.getBallBetweenBallNumber(ballNumber1, ballNumber2)).isEqualTo(3);
	}
}
