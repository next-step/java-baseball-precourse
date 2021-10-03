package util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.Ball;
import nextstep.utils.Randoms;

@DisplayName("숫자 생성 및 Ball 객체 변환 테스트")
public class BallGeneratorTest {

	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 9;

	@DisplayName("Randoms 유틸리티 유효성 검사")
	@RepeatedTest(name = "{displayName} - {currentRepetition} / {totalRepetitions}", value = 10)
	void isCorrectRange() {
		assertThat(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)).isGreaterThanOrEqualTo(MIN_VALUE);
		assertThat(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)).isLessThanOrEqualTo(MAX_VALUE);
	}

	@RepeatedTest(name = "{displayName}", value = 10)
	@DisplayName("생성된 숫자의 유효성 검사")
	void createNumber() {
		List<Ball> numbers = BallGenerator.createBalls();
		System.out.println(numbers);
		//TODO 테스트 작성 다시 해볼것
	}

	@ParameterizedTest
	@MethodSource("provideInputForConversion")
	@DisplayName("입력받은 숫자 변환 확인")
	void convertNumberList(String input, List<Ball> expected) {
		assertThat(BallGenerator.convertInput(input)).isEqualTo(expected);
	}

	private static Stream<Arguments> provideInputForConversion() {
		return Stream.of(
			Arguments.of("123", Arrays.asList(new Ball(1, 0), new Ball(2, 1), new Ball(3, 2))),
			Arguments.of("456", Arrays.asList(new Ball(4, 0), new Ball(5, 1), new Ball(6, 2))),
			Arguments.of("12", Arrays.asList(new Ball(1, 0), new Ball(2, 1))),
			Arguments.of("1", Arrays.asList(new Ball(1, 0)),
				Arguments.of("1234", Arrays.asList(new Ball(1, 0), new Ball(2, 1), new Ball(3, 2), new Ball(4, 4)))));
	}
}
