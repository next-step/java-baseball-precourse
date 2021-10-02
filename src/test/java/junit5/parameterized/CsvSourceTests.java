package junit5.parameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import junit5.service.Calculator;
import junit5.service.StringHelper;

@Disabled
public class CsvSourceTests {

	private Calculator calculator = new Calculator();
	private StringHelper stringHelper = new StringHelper();

	@ParameterizedTest
	@CsvSource({"car, rac", "sunday, yadnus", "test, tset",})
	public void testReverseWithCsvSource(String input, String expect) {
		assertEquals(expect, stringHelper.reverse(input));
	}

}
