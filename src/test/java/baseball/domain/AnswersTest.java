package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

class AnswersTest {
	/**
	 * @author : yh22953905
	 * @Date : 2021/10/05 12:09 오전
	 * @Description : {@link Answers#init()} 테스트
	 *
	 **/
	@Test
	void 임의의_수_선택했을_때_사이즈는_3() {
		Answers answers = Answers.init();

		assertEquals(answers.getAnswers().size(), 3);
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/05 12:09 오전
	 * @Description : {@link Answers#init()} 테스트
	 *
	 **/
	@Test
	void 임의의_수_선택했을_때_중복_숫자_없음() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 1, 2, 2, 3);

			Answers answers = Answers.init();

			Set<String> answerSet = new HashSet<>(answers.getAnswers());
			assertEquals(answerSet.size(), 3);
		}
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/05 12:09 오전
	 * @Description : {@link Answers#isStrike(List, int)} 테스트
	 *
	 **/
	@ParameterizedTest
	@CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
	void 스트라이크_판단(int index, boolean bool) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 4, 5);

			Answers answers = Answers.init();

			assertEquals(answers.isStrike(Arrays.asList("1", "2", "3"), index), bool);
		}
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/05 12:09 오전
	 * @Description : {@link Answers#isBall(String)} 테스트
	 *
	 **/
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
	void 볼_판단(String input, boolean bool) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 4, 5);

			Answers answers = Answers.init();

			assertEquals(answers.isBall(input), bool);
		}
	}
}