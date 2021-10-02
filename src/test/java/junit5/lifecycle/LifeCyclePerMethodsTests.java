package junit5.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@Disabled
@TestInstance(Lifecycle.PER_METHOD)
public class LifeCyclePerMethodsTests {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("@BeforeAll executed");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("@BeforeEach executed");
	}

	public LifeCyclePerMethodsTests() {
		System.out.println("Constructor executed");
	}

	@Test
	public void testOne() {
		System.out.println("testOne() executed");
	}

	@Test
	public void testTwo() {
		System.out.println("testTwo() executed");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("@AfterEach executed");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("@AfterAll executed");
	}
}
