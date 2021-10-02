package junit5.dynamic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import junit5.service.StringHelper;

@Disabled
public class DynamicTests {

	private static StringHelper stringHelper = new StringHelper();

	@TestFactory
	public DynamicTest testReverse() {

		return DynamicTest.dynamicTest("Dynamic Test for reverse method", () -> {
			assertEquals("god", stringHelper.reverse("dog"));
		});
	}

	@TestFactory
	public String testReverseWithString() {
		return "dynamic test";
	}

	@TestFactory
	public Collection<DynamicTest> dynamicTestFromCollection() {
		List<String> inputList = createInputList();
		List<String> outputList = createOutputList();

		Collection<DynamicTest> dynamicTests = new ArrayList<>();

		for (int i = 0; i < inputList.size(); i++) {
			String input = inputList.get(i);
			String output = outputList.get(i);

			DynamicTest dynamicTest = DynamicTest.dynamicTest("Dynamic Test for reverse() : input - " + input, () -> {
				assertEquals(output, stringHelper.reverse(input));
			});

			dynamicTests.add(dynamicTest);
		}

		return dynamicTests;
	}

	private List<String> createOutputList() {
		return Arrays.asList("ecar", "mom", "dad");
	}

	private List<String> createInputList() {
		return Arrays.asList("race", "mom", "dad");
	}
}
