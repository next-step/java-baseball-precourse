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

		List randomValue = computer.getRandomValue();

		assertThat(randomValue.size()).isEqualTo(3);
		assertThat(randomValue.get(0)).isNotEqualTo(randomValue.get(1));
		assertThat(randomValue.get(1)).isNotEqualTo(randomValue.get(2));
		assertThat(randomValue.get(2)).isNotEqualTo(randomValue.get(0));

	}

}
