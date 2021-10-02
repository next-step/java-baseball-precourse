package baseball.domain;

import static baseball.config.ConfigBaseball.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	private Computer computer = null;

	@BeforeEach
	void init() {
		computer = new Computer();
	}

	@Test
	@DisplayName("1부터 9까지 중복되지 않는 임의의 수 3개를 선택한다.")
	void 게임시작_직후_3개의수생성() {
		List randomValue = computer.getClearRandomValue();

		assertThat(randomValue.size()).isEqualTo(INPUT_SIZE);
		assertThat(randomValue.get(0)).isNotEqualTo(randomValue.get(1));
		assertThat(randomValue.get(1)).isNotEqualTo(randomValue.get(2));
		assertThat(randomValue.get(2)).isNotEqualTo(randomValue.get(0));

	}

	@Test
	@DisplayName("같은 수가 같은 자리에 있는지 체크하여 쓰리스트라이크 확인")
	void 쓰리스트라이크_확인() {
		ArrayList randomValue = (ArrayList)computer.getClearRandomValue();
		ArrayList userInput = (ArrayList)randomValue.clone();

		computer.checkStrike(randomValue, userInput);
		assertThat(computer.getStrike()).isEqualTo(INPUT_SIZE);

		computer.makeHint();
		assertThat(computer.getHint()).isEqualTo(INPUT_SIZE + "스트라이크 ");
	}

	@Test
	@DisplayName("같은 수가 같은 자리에 있는지 체크하여 투스트라이크 확인")
	void 투스트라이크_확인() {
		ArrayList randomValue = (ArrayList)computer.getClearRandomValue();
		ArrayList userInput = (ArrayList)randomValue.clone();
		userInput.set(0, 11);

		computer.checkStrike(randomValue, userInput);
		assertThat(computer.getStrike()).isEqualTo(INPUT_SIZE - 1);
		assertThat(Arrays.equals(randomValue.toArray(), userInput.toArray())).isFalse();

		computer.makeHint();
		assertThat(computer.getHint()).isEqualTo(INPUT_SIZE - 1 + "스트라이크 ");
	}

}
