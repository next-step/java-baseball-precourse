package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.constants.ResultEnum;

public class GameTest {

	Game game;

	private static Stream<Arguments> provideAnswerCheckArgument() {
		return Stream.of(
			Arguments.of(9, 0, ResultEnum.STRIKE),
			Arguments.of(9, 1, ResultEnum.BALL),
			Arguments.of(9, 2, ResultEnum.BALL),
			Arguments.of(8, 0, ResultEnum.BALL),
			Arguments.of(8, 1, ResultEnum.STRIKE),
			Arguments.of(8, 2, ResultEnum.BALL),
			Arguments.of(7, 0, ResultEnum.BALL),
			Arguments.of(7, 1, ResultEnum.BALL),
			Arguments.of(7, 2, ResultEnum.STRIKE),
			Arguments.of(4, 1, ResultEnum.NOT),
			Arguments.of(5, 1, ResultEnum.NOT),
			Arguments.of(6, 1, ResultEnum.NOT)
		);
	}

	private static Stream<Arguments> provideConvertToListValidArgs() {
		return Stream.of(
			Arguments.of("123", Arrays.asList(1, 2, 3)),
			Arguments.of("789", Arrays.asList(7, 8, 9)),
			Arguments.of("777", Arrays.asList(7, 7, 7)),
			Arguments.of("-123", Arrays.asList(-1, 2, 3))
		);
	}

	@BeforeEach
	void init() {
		game = new Game(Arrays.asList(9, 8, 7));
	}

	@DisplayName("1. 값과 위치에 따라 정답 확인")
	@ParameterizedTest(name = "{displayName} {0},{1}  -> {2}")
	@MethodSource("provideAnswerCheckArgument")
	void checkAnswerTest(int value, int idx, ResultEnum resultEnum) {
		assertThat(game.checkAnswer(value, idx)).isEqualTo(resultEnum);
	}

	@DisplayName("2. 입력된 값에 결과 도출")
	@ParameterizedTest(name = "{displayName} {0} -> {1}")
	@CsvSource({
		"123,		false,		낫싱",
		"987,		true,		3개의 숫자를 모두 맞추셨습니다! 게임 끝",
		"187,		false,		2 스트라이크",
		"978,		false,		1 스트라이크 2 볼",
		"781,		false,		1 스트라이크 1 볼",
		"127,		false,		1 스트라이크",
		"798,		false,		3 볼",
		"792,		false,		2 볼",
		"276,		false,		1 볼"
	})
	void tryTypeTest(String input, boolean isWin, String msg) {
		TryResult result = game.tryInput(input);
		assertThat(result.isWin())
			.isEqualTo(isWin);
		assertThat(result.toString())
			.contains(msg);
	}

	@DisplayName("3. 입력 변환 (유효성 검사)")
	@ParameterizedTest(name = "{displayName} {0} -> {1}")
	@MethodSource("provideConvertToListValidArgs")
	void validStringConvertToListTest(String input, List<Integer> list) {
		List<Integer> result = game.convertToList(input);
		assertEquals(input.length(), result.size());
		assertThat(result)
			.isInstanceOf(ArrayList.class)
			.containsAll(list);

	}

	@DisplayName("4. 정답 생성")
	@Test
	void getAnswerPatternTest() {
		assertThat(game.getAnswer())
			.isNotEmpty()
			.isInstanceOf(ArrayList.class)
			.hasSize(3)
			.doesNotHaveDuplicates();

		for (int i : game.getAnswer()) {
			assertThat(i).matches(j -> j >= 0 && j <= 9);
		}

	}
}
