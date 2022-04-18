package baseball.logic;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseBallGameLogicTest {

	private List<Integer> randNumbers;

	@BeforeEach
	void setUp() {
		randNumbers = (List<Integer>)new BaseBallGameLogic().generateNumbers();
	}

	@Test
	void 랜덤숫자_SIZE_CHECK() {
		assertThat(randNumbers.size() == 3).isTrue();
	}

	@Test
	void 랜덤숫자_유효성_CHECK() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		randNumbers.removeAll(numbers);
		assertThat(randNumbers.size()).isZero();
	}

}