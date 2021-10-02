package junit5.repeat;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTests {

	@RepeatedTest(name = "{displayName} - {currentRepetition} / {totalRepetitions}", value = 2)
	@DisplayName("Simple Repeated Test")
	public void simpleRepeatedTest() {
		assertTrue(0 < 5);
	}

	@RepeatedTest(name = RepeatedTest.LONG_DISPLAY_NAME, value = 2)
	@DisplayName("Simple Repeated Test")
	public void simpleRepeatedTestWithLongDisplayName() {
		assertTrue(0 < 5);
	}

	@RepeatedTest(name = RepeatedTest.SHORT_DISPLAY_NAME, value = 2)
	@DisplayName("Simple Repeated Test")
	public void simpleRepeatedTestWithShortDisplayName() {
		assertTrue(0 < 5);
	}

}
