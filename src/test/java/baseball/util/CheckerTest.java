package baseball.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

class CheckerTest extends NSTest {
	/**
	 * @author : yh22953905
	 * @Date : 2021/10/05 9:43 오후
	 * @Description : {@link Checker#checkInput(String)} 테스트
	 *
	 **/
	@ParameterizedTest
	@CsvSource(value = {"1:123:true", "2:123:false", ":124:true"}, delimiter = ':')
	void 스트라이크_볼_낫싱_판단_후_재시작_여부(String inputForRestart, String inputForCheck, boolean result) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 2, 3, 4, 5, 6);
			run(inputForRestart);

			Checker checker = Checker.init();

			assertEquals(checker.checkInput(inputForCheck), result);
		}
	}

	@Override
	public void runMain() {
	}
}