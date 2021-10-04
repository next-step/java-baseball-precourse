package baseball.domain;

import baseball.exception.BaseballInputException;
import baseball.exception.BaseballInputSizeException;
import baseball.exception.BaseballInputZeroException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("숫자야구 Domain Test")
class BaseballNumberTest {

	@DisplayName("랜덤 숫자 생성(숫자야구 생성자) Test")
	@RepeatedTest(10)
	public void BaseBallNumberTest() {
		BaseballNumber baseballNumber = new BaseballNumber();
		for (int i = 0; i < 3; i++) {
			assertTrue(baseballNumber.getValueByIndex(i) < 10 && baseballNumber.getValueByIndex(i) > 0);
		}
		assertTrue(baseballNumber.getValueByIndex(0) != baseballNumber.getValueByIndex(1));
		assertTrue(baseballNumber.getValueByIndex(0) != baseballNumber.getValueByIndex(2));
		assertTrue(baseballNumber.getValueByIndex(1) != baseballNumber.getValueByIndex(2));
	}

	@DisplayName("서로다른 숫자 생성 Test")
	@RepeatedTest(10)
	public void pickRandomNumberTest() {
		BaseballNumber baseballNumber = new BaseballNumber();
		assertTrue(baseballNumber.getValueByIndex(0) != baseballNumber.getValueByIndex(1));
		assertTrue(baseballNumber.getValueByIndex(0) != baseballNumber.getValueByIndex(2));
		assertTrue(baseballNumber.getValueByIndex(1) != baseballNumber.getValueByIndex(2));
	}

	@DisplayName("입력숫자 input Test")
	@ParameterizedTest
	@ValueSource(ints = {123, 456, 789, 534, 472})
	public void BaseballNumberArgTest(int inputNumber) {
		BaseballNumber baseballNumber = new BaseballNumber(inputNumber);
		assertTrue(
			"123".equals(baseballNumber.numberToString()) ||
				"456".equals(baseballNumber.numberToString()) ||
				"789".equals(baseballNumber.numberToString()) ||
				"534".equals(baseballNumber.numberToString()) ||
				"472".equals(baseballNumber.numberToString())
		);
	}

	@DisplayName("입력숫자 유효성 체크 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 12, 1253, 53, 9128, 28314, 205, 903, 104, 680})
	public void checkValidateTest(int inputNumber) {
		assertThrows(BaseballInputException.class, () -> new BaseballNumber(inputNumber));
	}

	@DisplayName("입력숫자 Size 유효성 체크 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 12, 1253, 53, 9128, 28314})
	public void checkSizeValidateTest(int inputNumber) {
		assertThrows(BaseballInputSizeException.class, () -> new BaseballNumber(inputNumber));
	}

	@DisplayName("입력숫자 0 존재여부 테스트")
	@ParameterizedTest
	@ValueSource(ints = {205, 903, 104, 680})
	public void checkZeroValidateTest(int inputNumber) {
		assertThrows(BaseballInputZeroException.class, () -> new BaseballNumber(inputNumber));
	}

	@DisplayName("숫자 toString 테스트")
	@ParameterizedTest
	@ValueSource(ints = {123, 456, 789})
	public void numberToStringTest(int inputNumber) {
		BaseballNumber baseballNumber = new BaseballNumber(inputNumber);
		assertTrue(
			"123".equals(baseballNumber.numberToString()) ||
				"456".equals(baseballNumber.numberToString()) ||
				"789".equals(baseballNumber.numberToString())
		);
	}
}