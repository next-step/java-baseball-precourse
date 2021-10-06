package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.ErrorMessage;
import baseball.exception.DuplicationNumberException;

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

}