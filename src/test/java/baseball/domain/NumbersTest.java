package baseball.domain;

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
			.hasSize(Numbers.SIZE)
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

	@Test
	@DisplayName("지정된 Number가 존재하면 true 아니면 false")
	void isContains() {
		// given
		Numbers numbers = new Numbers(Arrays.asList(1, 2, 3));

		assertAll(
			() -> {
				// when
				boolean isExistsNumber = numbers.isContains(new Number(1));

				// then
				assertThat(isExistsNumber).isTrue();
			},
			() -> {
				// when
				boolean isNotExistsNumber = numbers.isContains(new Number(4));

				// then
				assertThat(isNotExistsNumber).isFalse();
			}
		);
	}

	@Test
	@DisplayName("지정된 Number의 자릿수를 반환한다.")
	void getDigit() {
		// given
		Numbers numbers = new Numbers(Arrays.asList(2, 3, 1));

		// when
		int digitOfFirst = numbers.getDigit(new Number(2));
		int digitOfSecond = numbers.getDigit(new Number(3));
		int digitOfThird = numbers.getDigit(new Number(1));

		// then
		assertAll(
			() -> assertThat(digitOfFirst).isEqualTo(1),
			() -> assertThat(digitOfSecond).isEqualTo(2),
			() -> assertThat(digitOfThird).isEqualTo(3)
		);
	}

	@Test
	@DisplayName("인덱스에 해당되는 Number를 반환한다.")
	void get() {
		// given
		Numbers numbers = new Numbers(Arrays.asList(2, 3, 1));

		assertAll(
			() -> assertThat(numbers.get(0)).isEqualTo(new Number(2)),
			() -> assertThat(numbers.get(1)).isEqualTo(new Number(3)),
			() -> assertThat(numbers.get(2)).isEqualTo(new Number(1))
		);
	}
}