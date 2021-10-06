package baseball.controller;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.ConstValue;

public class OpponentBaseballNumberGeneratorTest {
	private List<Integer> opponentNumbers;

	@BeforeEach
	void setup() {
		opponentNumbers = OpponentBaseballNumberGenerator.generateOpponentBaseBallNumber();
	}

	@DisplayName("숫자 자리수 검사")
	@Test
	void validateNumberFigures() {
		assertThat(opponentNumbers.size())
			.isEqualTo(ConstValue.BASEBALL_SIZE);
	}

	@DisplayName("숫자 중복 검사")
	@Test
	void validateNumberDuplicated() {
		HashSet<Integer> validationNumbers = new HashSet<>(opponentNumbers);

		assertThat(validationNumbers.size())
			.isEqualTo(ConstValue.BASEBALL_SIZE);
	}
}
