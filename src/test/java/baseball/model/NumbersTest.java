package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumbersSizeException;

class NumbersTest {
	@Test
	@DisplayName("숫자와 자릿수를 가지고 있는 일급 컬렉션 Numbers 인스턴스 생성한다.")
	void create() {
		// given
		List<Integer> list = Arrays.asList(1, 2, 3);

		// when
		Numbers numbers = new Numbers(list);

		// then
		assertThat(numbers.getValues())
			.hasSize(3)
			.contains(new Number(1), new Number(2), new Number(3));
	}

	@Test
	@DisplayName("세 자리수가 아닌 숫자 입력시 InvalidNumbersSizeException 예외가 발생한다.")
	void create_should_throw_exception_when_digit_over() {
		// then
		assertAll(
			() -> assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 2, 3, 4)))
				.isInstanceOf(InvalidNumbersSizeException.class)
				.hasMessage("The number of digits must be %d.", Numbers.SIZE),
			() -> assertThatThrownBy(() -> new Numbers(Arrays.asList(1, 2)))
				.isInstanceOf(InvalidNumbersSizeException.class)
				.hasMessage("The number of digits must be %d.", Numbers.SIZE)
		);
	}

	@Test
	@DisplayName("중복된 숫자가 있시 DuplicateNumberException 예외가 발생한다.")
	void create_should_throw_exception_when_already_exists_number() {
		// given
		List<Integer> list = Arrays.asList(1, 1, 2);

		// then
		assertThatThrownBy(() -> new Numbers(list))
			.isInstanceOf(DuplicateNumberException.class)
			.hasMessage("Duplicate numbers are not available.");
	}
}