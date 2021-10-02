package util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.utils.Randoms;

@DisplayName("숫자 생성 및 변환 테스트")
public class NumberGeneratorTest {

	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 9;

	@DisplayName("Randoms 유틸리티 유효성 검사")
	@RepeatedTest(name = "{displayName} - {currentRepetition} / {totalRepetitions}", value = 10)
	void isCorrectRange() {
		assertThat(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)).isGreaterThanOrEqualTo(MIN_VALUE);
		assertThat(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)).isLessThanOrEqualTo(MAX_VALUE);
	}

	@Test
	@DisplayName("생성된 숫자의 유효성 검사")
	void createNumber() {
		List<Integer> numbers = NumberGenerator.createNumber();
		//TODO 테스트 작성 다시 해볼것
	}

	@ParameterizedTest
	@MethodSource("provideInputForConversion")
	@DisplayName("입력받은 숫자 변환 확인")
	void convertNumberList(String input, List<Integer> expected) {
		assertThat(NumberGenerator.convertInput(input)).isEqualTo(expected);
	}

	private static Stream<Arguments> provideInputForConversion() {
		return Stream.of(
			Arguments.of("123", Arrays.asList(1, 2, 3)),
			Arguments.of("456", Arrays.asList(4, 5, 6)),
			Arguments.of("12", Arrays.asList(1, 2)),
			Arguments.of("1", Arrays.asList(1)),
			Arguments.of("1234", Arrays.asList(1, 2, 3, 4)));
	}
}
