package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	@DisplayName("사용자는 컴퓨터가 생각하고 있는 3개의 숫자를 입력한다.")
	void 게임시작_직후_3개의수입력() {
		User user = new User();

		List input = user.getInput();

		assertThat(input.size()).isEqualTo(3);

	}

}
