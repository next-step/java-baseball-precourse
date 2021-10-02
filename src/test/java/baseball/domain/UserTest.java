package baseball.domain;

import static baseball.config.ConfigBaseball.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	/**
	 * 기능개발용 테스트(UI로직)이며 과제 제출시 삭제예정
	 */
	@Test
	@DisplayName("사용자는 컴퓨터가 생각하고 있는 3개의 숫자를 입력한다. 잘못 입력할 경우 [ERROR]메시지 출력")
	void 게임시작_직후_3개의수입력() {
		User user = new User();

		List input = user.clearInputReadLine();

		assertThat(input.size()).isEqualTo(INPUT_SIZE);

	}

}
