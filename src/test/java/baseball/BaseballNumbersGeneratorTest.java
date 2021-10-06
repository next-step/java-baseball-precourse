package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.view.Input;

class BaseballNumbersGeneratorTest {
	@DisplayName("중복된 값이 입력되면 예외가 발생한다")
	@Test
	void given_duplicated_numbers_then_throw_exception() {
		input("122");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(()->BaseballNumbersGenerator.createBaseballNumbers(Input.readPlayerInput()))
			.withMessage("입력 된 숫자에 중복이 있으면 안됩니다.");
	}

	@DisplayName("3개의 숫자가 아니면 예외가 발생한다")
	@Test
	void given_number_other_than_three_then_throw_exception() {
		input("12d");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(()->BaseballNumbersGenerator.createBaseballNumbers(Input.readPlayerInput()))
			.withMessage("3개의 숫자(1~9)를 입력 하세요.");
	}

	@DisplayName("1과 9사이의 숫자가 아니면 예외가 발생한다")
	@Test
	void given_not_between_1_and_9_then_throw_exception() {
		input("109");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(()->BaseballNumbersGenerator.createBaseballNumbers(Input.readPlayerInput()))
			.withMessage("3개의 숫자(1~9)를 입력 하세요.");
	}

	@DisplayName("입력 값이 없으면 예외가 발생한다")
	@Test
	void when_no_input_value_then_throw_exception() {
		input("");
		assertThatExceptionOfType(NoSuchElementException.class)
			.isThrownBy(()->BaseballNumbersGenerator.createBaseballNumbers(Input.readPlayerInput()));
	}

	private void input(String value) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
		System.setIn(inputStream);
	}
}