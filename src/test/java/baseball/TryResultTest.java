package baseball;

import static baseball.constants.MessageConstant.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.constants.ResultEnum;

public class TryResultTest {

	private TryResult tryResult;

	private static Stream<Arguments> provideResultEnums() {
		return Stream.of(
			Arguments.of(Arrays.asList(ResultEnum.STRIKE, ResultEnum.STRIKE, ResultEnum.STRIKE), WIN_MESSAGE),
			Arguments.of(Arrays.asList(ResultEnum.STRIKE, ResultEnum.STRIKE, ResultEnum.BALL), "2 스트라이크 1 볼"),
			Arguments.of(Arrays.asList(ResultEnum.STRIKE, ResultEnum.STRIKE, ResultEnum.NOT), "2 스트라이크"),
			Arguments.of(Arrays.asList(ResultEnum.STRIKE, ResultEnum.BALL, ResultEnum.BALL), "1 스트라이크 2 볼"),
			Arguments.of(Arrays.asList(ResultEnum.STRIKE, ResultEnum.BALL, ResultEnum.NOT), "1 스트라이크 1 볼"),
			Arguments.of(Arrays.asList(ResultEnum.STRIKE, ResultEnum.NOT, ResultEnum.NOT), "1 스트라이크"),
			Arguments.of(Arrays.asList(ResultEnum.BALL, ResultEnum.BALL, ResultEnum.BALL), "3 볼"),
			Arguments.of(Arrays.asList(ResultEnum.BALL, ResultEnum.BALL, ResultEnum.NOT), "2 볼"),
			Arguments.of(Arrays.asList(ResultEnum.BALL, ResultEnum.NOT, ResultEnum.NOT), "1 볼"),
			Arguments.of(Arrays.asList(ResultEnum.NOT, ResultEnum.NOT, ResultEnum.NOT), NOTHING_MESSAGE)
		);
	}

	@BeforeEach
	void init() {
		tryResult = new TryResult();
	}

	@DisplayName("1. 결과 입력에 따른 메세지 출력 테스트")
	@ParameterizedTest(name = "{displayName} {index} [{0}]")
	@MethodSource("provideResultEnums")
	void addResultTest(List<ResultEnum> resultList, String resultString) {
		for (ResultEnum result : resultList) {
			tryResult.addResultEnum(result);
		}
		assertThat(tryResult)
			.asString()
			.contains(resultString);
	}

	@DisplayName("2. 승리 결과 반환 테스트")
	@Test
	void isWinTest() {
		for (int i = 0; i < 3; i++) {
			tryResult.addResultEnum(ResultEnum.STRIKE);
		}
		assertThat(tryResult.isWin())
			.isTrue();
	}

}
