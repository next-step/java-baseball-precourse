package junit5.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class LifeCyclePerClassTests {

	@BeforeAll
	public void beforeAll() {
		System.out.println("@BeforeAll executed");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("@BeforeEach executed");
	}

	public LifeCyclePerClassTests() {
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
	public void afterAll() {
		System.out.println("@AfterAll executed");
	}
}
