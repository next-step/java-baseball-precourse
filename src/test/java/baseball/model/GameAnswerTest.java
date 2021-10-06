package baseball.model;

import static org.mockito.Mockito.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class GameAnswerTest {
	GameAnswer gameAnswer = new GameAnswer();

	@Test
	void 생성_및_비교() {
		try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5);
			// given
			gameAnswer.generateAnswer();

			// when
			CompareResult result = gameAnswer.compare(new int[] {1, 3, 5});
			boolean isAnswer = result.isAnswer();

			// then
			Assertions.assertThat(isAnswer).isTrue();
		}
	}
}
