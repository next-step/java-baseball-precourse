package baseball;

import static baseball.Constants.MessageConstant.*;
import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.InputMismatchException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

	Validator validator;

	@BeforeEach
	void init() {
		validator = new Validator();
	}

	@DisplayName("1. 정규식 확인")
	@ParameterizedTest(name = "{displayName} {index} [{0}]")
	@CsvSource({
		"123,		^([0-9])([0-9])([0-9])$,		true",
		"456,		^([0-9])([0-9])([0-9])$,		true",
		"789,		^([0-9])([0-9])([0-9])$,		true",
		"111,		^([0-9])([0-9])([0-9])$,		true",
		"가92,		^([0-9])([0-9])([0-9])$,		false",
		"abc,		^([0-9])([0-9])([0-9])$,		false",
		"a^77,		^([0-9])([0-9])([0-9])$,		false",
		"99999,		^([0-9])([0-9])([0-9])$,		false",
		"1,			^([1-2])$,						true",
		"2,			^([1-2])$,						true",
		"233,		^([1-2])$,						false",
		"가,		^([1-2])$,						false"
	})
	void PatternCheckTest(String input, String pattern, boolean isPass) throws Exception {
		Method method = validator.getClass()
			.getDeclaredMethod("isMatchPattern", String.class, String.class);
		method.setAccessible(true);
		boolean result = (boolean)method.invoke(validator,input,pattern);

		assertThat(result).isEqualTo(isPass);
	}


	@DisplayName("2. 중복 확인")
	@ParameterizedTest(name = "{displayName} {index} [{0}]")
	@CsvSource({
		"123,		false",
		"가나다,		false",
		"789,		false",
		"111,		true",
		"바나나,		true",
		"li1,		false",
		"a^772,		true",
		"99999,		true",
		"\t12,		false",
	})
	void duplicatedTest(String input, boolean isPass) throws Exception {
		Method method = validator.getClass()
			.getDeclaredMethod("isDuplicated", String.class);
		method.setAccessible(true);
		boolean result = (boolean)method.invoke(validator,input);

		assertThat(result).isEqualTo(isPass);
	}

	@DisplayName("3. 게임 입력 예외 확인")
	@ParameterizedTest(name = "{displayName} {index} [{0}]")
	@ValueSource(strings = {"133","가나다","^^^@#","실패테스트입니다"})
	void validInGameInputTestFail(String input) {
		assertThatThrownBy(() -> {
			validator.validInputInGame(input);
		}).isInstanceOf(InputMismatchException.class)
			.hasMessage(INPUT_MISMATCH_MESSAGE);
	}

	@DisplayName("4. 새 게임 입력 예외 확인")
	@ParameterizedTest(name = "{displayName} {index} [{0}]")
	@ValueSource(strings = {"4","23","0"})
	void validNewGameInputTestFail(String input) {
		assertThatThrownBy(() -> {
			validator.validInputNewGame(input);
		}).isInstanceOf(InputMismatchException.class)
			.hasMessage(INPUT_MISMATCH_MESSAGE);
	}


}
