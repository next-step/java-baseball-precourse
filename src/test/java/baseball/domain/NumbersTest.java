package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.exception.ErrorMessage;
import baseball.domain.exception.DuplicationNumberException;
import baseball.domain.exception.NumberRangeInvalidException;

class NumbersTest {

	@Test
	void 중복안됨_보장() {

		assertThatThrownBy(() -> {
			Numbers numbers = new Numbers("111");
		})
		.isInstanceOf(DuplicationNumberException.class)
			.hasMessage(ErrorMessage.DUPLICATION_NUMBER_EXCEPTION.getMessage())
		;

	}

	@ParameterizedTest
	@ValueSource(strings = {"11", "1111", "1"})
	@DisplayName("자릿수_체크")
	void 자릿수_체크(){

		assertThatThrownBy(() -> {
			Numbers numbers = new Numbers("1111");
		})
			.isInstanceOf(NumberRangeInvalidException.class)
			.hasMessage(ErrorMessage.NUMBER_RANGE_INVALID_EXCEPTION.getMessage())
		;
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "465", "789"})
	@DisplayName("정상 생성")
	void 정상_생성(String value){
		Numbers numbers = new Numbers(value);
	}
}