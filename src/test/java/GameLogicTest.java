import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class GameLogicTest {

	@Test
	void ballTest() {
		assertEquals(BaseballGame.getBall("012", "157"), 1);
		assertEquals(BaseballGame.getBall("278", "284"), 1);
		assertEquals(BaseballGame.getBall("077", "765"), 1);
		assertEquals(BaseballGame.getBall("479", "943"), 2);
		assertEquals(BaseballGame.getBall("112", "251"), 2);
		assertEquals(BaseballGame.getBall("456", "645"), 3);
		assertEquals(BaseballGame.getBall("065", "650"), 3);
	}

	@Test
	void strikeTest() {
		assertEquals(BaseballGame.getStrike("012", "516"), 1);
		assertEquals(BaseballGame.getStrike("278", "284"), 1);
		assertEquals(BaseballGame.getStrike("077", "570"), 1);
		assertEquals(BaseballGame.getStrike("479", "469"), 2);
		assertEquals(BaseballGame.getStrike("112", "132"), 2);
		assertEquals(BaseballGame.getStrike("456", "456"), 3);
		assertEquals(BaseballGame.getStrike("065", "065"), 3);
	}

	@Test
	void numberContainTest() {
		assertTrue(BaseballGame.isNumberContains("012", '0'));
		assertTrue(BaseballGame.isNumberContains("012", '1'));
		assertTrue(BaseballGame.isNumberContains("012", '2'));
		assertTrue(BaseballGame.isNumberContains("469", '4'));
		assertTrue(BaseballGame.isNumberContains("469", '6'));
		assertTrue(BaseballGame.isNumberContains("469", '9'));
		assertFalse(BaseballGame.isNumberContains("012", '8'));
		assertFalse(BaseballGame.isNumberContains("012", '7'));
		assertFalse(BaseballGame.isNumberContains("012", '5'));
		assertFalse(BaseballGame.isNumberContains("469", '2'));
		assertFalse(BaseballGame.isNumberContains("469", '0'));
		assertFalse(BaseballGame.isNumberContains("469", '1'));
	}

	@Test
	void randomAnswerGenerationTest() {
		for (int i = 0; i < 10; i++) {
			String num = BaseballGame.createRandomNumber();
			assertEquals(num.length(), 3);
			assertTrue(num.charAt(0) >= '0' && num.charAt(0) <= '9');
			assertTrue(num.charAt(1) >= '0' && num.charAt(1) <= '9');
			assertTrue(num.charAt(2) >= '0' && num.charAt(2) <= '9');
		}
	}
}
