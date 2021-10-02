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
	void 게임시작_직후_3개의수_생성() {
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

		int strike = computer.checkStrike(randomValue, userInput);
		assertThat(strike).isEqualTo(INPUT_SIZE);
		assertThat(Arrays.equals(randomValue.toArray(), userInput.toArray())).isTrue();

		computer.makeHint();
		assertThat(computer.getHint()).isEqualTo(INPUT_SIZE + HINT_STRIKE_MESSAGE);
	}

	@Test
	@DisplayName("같은 수가 같은 자리에 있는지 체크하여 투스트라이크 확인")
	void 투스트라이크_확인() {
		ArrayList randomValue = (ArrayList)computer.getClearRandomValue();
		ArrayList userInput = (ArrayList)randomValue.clone();
		userInput.set(0, 11);

		int strike = computer.checkStrike(randomValue, userInput);
		assertThat(strike).isEqualTo(INPUT_SIZE - 1);
		assertThat(Arrays.equals(randomValue.toArray(), userInput.toArray())).isFalse();

		computer.makeHint();
		assertThat(computer.getHint()).isEqualTo(INPUT_SIZE - 1 + HINT_STRIKE_MESSAGE);
	}

	@Test
	@DisplayName("같은 수이며 자리가 다른수가 한개인지 확인")
	void 원볼_확인() {
		List randomValue = computer.getClearRandomValue();
		List userInput = Arrays.asList(randomValue.get(2), "x", "x");

		int ball = computer.checkBall(randomValue, userInput);
		assertThat(ball).isEqualTo(INPUT_SIZE - 2);

		String hint = computer.makeHint();
		assertThat(hint).isEqualTo(INPUT_SIZE - 2 + HINT_BALL_MESSAGE);
	}

	@Test
	@DisplayName("같은 수이며 자리가 다른수가 두개인지 확인")
	void 투볼_확인() {
		List randomValue = computer.getClearRandomValue();
		List userInput = Arrays.asList(randomValue.get(2), randomValue.get(1), randomValue.get(0));

		int ball = computer.checkBall(randomValue, userInput);
		assertThat(ball).isEqualTo(INPUT_SIZE - 1);

		String hint = computer.makeHint();
		assertThat(hint).isEqualTo(INPUT_SIZE - 1 + HINT_BALL_MESSAGE);
	}

	@Test
	@DisplayName("같은 수 이며 같은자리가 한개, 같은 수 이며 다른자리가 한개인지 확인")
	void 원스트라이크_원볼_확인() {
		List randomValue = computer.getClearRandomValue();
		List userInput = Arrays.asList(randomValue.get(0), randomValue.get(2), Integer.MIN_VALUE);

		int strike = computer.checkStrike(randomValue, userInput);
		int ball = computer.checkBall(randomValue, userInput);

		String hint = computer.makeHint();
		assertThat(hint).isEqualTo((INPUT_SIZE - 2) + HINT_STRIKE_MESSAGE + " "
			+ (INPUT_SIZE - 2) + HINT_BALL_MESSAGE);
	}

}
