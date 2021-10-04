package baseball.model;

import baseball.dto.ResultDto;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class GameTest {

	@Test
	public void newGameTest() {
		try {
			Game game = new Game();
			Field field = game.getClass().getDeclaredField("targets");
			field.setAccessible(true);
			Set<Target> targets = (Set<Target>) field.get(game);
			assertThat(targets)
					.allSatisfy(target -> {
						assertThat(target.hashCode())
								.isBetween(1,9);
					})
					.hasSize(3)
					.containsOnlyOnce(targets.toArray(new Target[3]));
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void checkTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(7, 1, 3);
			Game game = new Game();
			Set<Input> inputs = new LinkedHashSet<>();
			inputs.add(new Input(0, 7));
			inputs.add(new Input(1, 1));
			inputs.add(new Input(2, 3));
			ResultDto resultDto = game.check(inputs);
			assertThat(resultDto.getMessage())
					.contains("3스트라이크");
			assertThat(resultDto.isEnd())
					.isTrue();

			inputs.clear();
			inputs.add(new Input(0, 1));
			inputs.add(new Input(1, 9));
			inputs.add(new Input(2, 3));
			resultDto = game.check(inputs);
			assertThat(resultDto.getMessage())
					.contains("1스트라이크 1볼");
			assertThat(resultDto.isEnd())
					.isFalse();

			inputs.clear();
			inputs.add(new Input(0, 4));
			inputs.add(new Input(1, 6));
			inputs.add(new Input(2, 5));
			resultDto = game.check(inputs);
			assertThat(resultDto.getMessage())
					.contains("낫싱");
			assertThat(resultDto.isEnd())
					.isFalse();
		}
	}
}
