package baseball.view;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import baseball.domain.Numbers;
import baseball.domain.Player;
import nextstep.utils.Console;

class InputViewTest {
	@Test
	@DisplayName("사용자가 입력한 숫자 문자열을 토대로 Player를 생성한다.")
	void getPlayer() {
		try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
			mockConsole.when(Console::readLine)
				.thenReturn("1234", "123");

			then(InputView.getPlayer())
				.isEqualTo(new Player(new Numbers(Arrays.asList(1, 2, 3))));
		}
	}

	@Test
	@DisplayName("게임을 다시 시작할건지 여부를 판단한다.")
	void isRestartGame() {
		try (final MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
			mockConsole.when(Console::readLine)
				.thenReturn("test", GameConsoleCommand.END_GAME.getCommandStringValue());

			then(InputView.isRestartGame())
				.isFalse();
		}
	}
}