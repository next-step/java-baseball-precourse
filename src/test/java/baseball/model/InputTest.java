package baseball.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class InputTest {

	@Test
	public void hitTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(7, 1, 3);
			Game game = new Game();
			Field field = game.getClass().getDeclaredField("targets");
			field.setAccessible(true);
			Set<Target> targets = (Set<Target>) field.get(game);

			Input input = new Input(0, 4);
			input.hit(targets);
			assertThat(input.isBall())
					.isFalse();
			assertThat(input.isStrike())
					.isFalse();

			input = new Input(1, 1);
			input.hit(targets);
			assertThat(input.isBall())
					.isFalse();
			assertThat(input.isStrike())
					.isTrue();

			input = new Input(2, 1);
			input.hit(targets);
			assertThat(input.isBall())
					.isTrue();
			assertThat(input.isStrike())
					.isFalse();
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
