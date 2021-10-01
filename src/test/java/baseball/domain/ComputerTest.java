package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	@DisplayName("1부터 9까지 중복되지 않는 임의의 수 3개를 선택한다.")
	void 게임시작_직후_3개의수생성() {
		Computer computer = new Computer();

		List input = computer.getInput();

		assertThat(input.size()).isEqualTo(3);
		assertThat(input.get(0)).isNotEqualTo(input.get(1));
		assertThat(input.get(1)).isNotEqualTo(input.get(2));
		assertThat(input.get(2)).isNotEqualTo(input.get(0));
	}

}
