package junit5.assumption;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class AssumingThatTests {

	@Test
	public void assumingThatWithBooleanCondition() {

		assumingThat("DEV".equals(System.getProperty("DEV")), () -> {
			System.out.println("Dev enviroment");
			assertEquals(3, 1 + 2);
		});

		System.out.println("Execute in every environment");
		assertEquals(3, 1 + 2);
	}
}
