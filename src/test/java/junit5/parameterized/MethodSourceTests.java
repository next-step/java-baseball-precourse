package junit5.parameterized;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import junit5.service.StringHelper;

import static org.junit.jupiter.api.Assertions.*;

public class MethodSourceTests {
	

	private StringHelper stringHelper = new StringHelper();

	@ParameterizedTest
	@MethodSource("stringProvider")
	public void methodSourceTest(String value) {
		assertNotNull(value);
	}

	@ParameterizedTest
	@MethodSource("argumentProvider")
	public void methodSourceWithArguments(String value, String expected) {
		assertEquals(expected, stringHelper.reverse(value));
	}

	public static Stream<String> stringProvider() {
		return Stream.of("dog", "cat", "mouse");
	}

	public static Stream<Arguments> argumentProvider() {
		return Stream.of(
				Arguments.arguments("car", "rac"), 
				Arguments.arguments("mom", "mom")
				);
	}
}
