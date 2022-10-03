package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import baseball.domain.Board;

public class BoardTest {
	private static Board computerBoard;

	@BeforeAll
	static void beforeAll() {
		computerBoard = new Board("753");
	}

	@Test
	void checkBoard() {
		assertThat(computerBoard.compareBoard(new Board("753")).getResultString()).isEqualTo("3스트라이크");
		assertThat(computerBoard.compareBoard(new Board("126")).getResultString()).isEqualTo("낫싱");
		assertThat(computerBoard.compareBoard(new Board("635")).getResultString()).isEqualTo("2볼");
	}

}
