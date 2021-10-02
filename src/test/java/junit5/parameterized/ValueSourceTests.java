package junit5.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import junit5.service.Calculator;
import junit5.service.StringHelper;

public class ValueSourceTests {

	private Calculator calculator = new Calculator();
	private StringHelper stringHelper = new StringHelper();

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 10 })
	public void test(int number) {
		assertTrue(calculator.isEvenNumber(number));
	}

	@ParameterizedTest
	@NullSource
	public void testReverseWithNullSource(String input) {
		assertNull(stringHelper.reverse(input));
	}

	@ParameterizedTest
	@EmptySource
	public void testReverseWithEmptySource(String input) {
		assertEquals("", stringHelper.reverse(input));
	}

	@ParameterizedTest
	@NullAndEmptySource
	public void testReverseWithNullAndEmptySource(String input) {
		assertEquals(input, stringHelper.reverse(input));
	}

	@ParameterizedTest
	@CsvSource({ "car, rac", "sunday, yadnus", "test, tset", })
	public void testReverseWithCsvSource(String input, String expect) {
		assertEquals(expect, stringHelper.reverse(input));
	}

}
