package junit5.assumption;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class AssumeTrueTests {

	@Test
	public void assumeTrueWithNoMessage() {

		assumeTrue(() -> "DEV".equals(System.getProperty("ENV")));
		System.out.println("Assumption Passed!!");
		assertEquals(3, 2 + 1);
	}

	@Test
	public void assumeTrueWithMessage() {

		assumeTrue(() -> "DEV".equals(System.getProperty("ENV")), "Assumption Failed !!!");
		System.out.println("Assumption Passed!!");
		assertEquals(3, 2 + 1);
	}

	@Test
	public void assumeTrueWithMessageSupplier() {

		assumeTrue(() -> "DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed !!!");
		System.out.println("Assumption Passed!!");
		assertEquals(3, 2 + 1);
	}

}
