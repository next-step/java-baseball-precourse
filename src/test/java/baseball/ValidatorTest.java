package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("유효성 검사 테스트")
public class ValidatorTest {

	private TestValidator testValidator;

	@BeforeEach
	void setUp() {
		testValidator = new TestValidator();
	}

	@ParameterizedTest
	@MethodSource("provideSuccessTestData")
	@DisplayName("모든 유효성 성공 테스트")
	void isNotValid(String input, boolean expected) {
		testValidator.isValid(input);
	}

	@ParameterizedTest
	@MethodSource("provideFailTestData")
	@DisplayName("모든 유효성 실패 테스트")
	void isNotValid(String input, String message) {
		assertThatIllegalArgumentException().isThrownBy(() -> testValidator.isValid(input)).withMessage(message);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:true", "1234:false", "1:false", "12:false", ":false", "'':false"}, delimiter = ':')
	@DisplayName("세 자리수 인지 확인")
	void isCorrectDigits(String input, boolean expected) {
		assertThat(testValidator.isCorrectDigits(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:true", "1230:false", "1:true", "012:false"}, delimiter = ':')
	@DisplayName("각 자리수 숫자의 범위가 1~9인지 확인")
	void isCorrectRangeForEachDigit(String input, boolean expected) {
		assertThat(testValidator.isCorrectRange(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:false", "1230:false", "11:true", "1233:true"}, delimiter = ':')
	@DisplayName("각 자리수의 값이 중복이 없는지 확인")
	void isDuplicated(String input, boolean expected) {
		assertThat(testValidator.isDuplicated(input)).isEqualTo(expected);
	}

	static private Stream<Arguments> provideFailTestData() {
		return Stream.of(
			Arguments.of("1", Validator.ErrorMessageType.INVALID_DIGITS.getMessage()),
			Arguments.of("012", Validator.ErrorMessageType.INVALID_RANGE_OF_NUMBER.getMessage()),
			Arguments.of("a12", Validator.ErrorMessageType.INVALID_RANGE_OF_NUMBER.getMessage()),
			Arguments.of("111", Validator.ErrorMessageType.DUPLICATED_NUMBER.getMessage()));
	}

	static private Stream<Arguments> provideSuccessTestData() {
		return Stream.of(
			Arguments.of("123", true),
			Arguments.of("456", true),
			Arguments.of("789", true),
			Arguments.of("146", true));
	}

	private class TestValidator extends Validator {

	}
}
