package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
	@Test
	@DisplayName("사용자가 입력한 문자열을 토대로 Player 인스턴스가 생성되는지")
	void create() {
		// given
		String intString = "123";

		// when
		Player player = Player.create(intString);

		// then
		assertThat(player)
			.isNotNull()
			.isEqualTo(new Player(new Numbers(Arrays.asList(1, 2, 3))));
	}
}