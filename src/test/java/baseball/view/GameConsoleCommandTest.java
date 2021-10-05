package baseball.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameConsoleCommandTest {
	@Test
	@DisplayName("명령어 문자열(재시작=1, 게임종료=2)로 게임 명령어 반환되는지.")
	void findFirstOrNull() {
		// given
		String command1 = "1";
		String command2 = "2";
		String command3 = "3";

		assertAll(
			() -> {
				// when
				GameConsoleCommand reStartCommand = GameConsoleCommand.findFirstOrNull(command1);

				// then
				assertThat(reStartCommand).isEqualTo(GameConsoleCommand.RESTART_GAME);
			},
			() -> {
				// when
				GameConsoleCommand endGameCommand = GameConsoleCommand.findFirstOrNull(command2);

				// then
				assertThat(endGameCommand).isEqualTo(GameConsoleCommand.END_GAME);
			},
			() -> {
				// when
				GameConsoleCommand undefinedCommand = GameConsoleCommand.findFirstOrNull(command3);

				// then
				assertThat(undefinedCommand).isNull();
			}
		);

	}
}