package nextstep.test;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
	public static List<Integer> convertNumbers(String input) {
		String[] inputArr = input.split("");
		List<Integer> numbers = new ArrayList<>();
		for (String s : inputArr) {
			numbers.add(Integer.valueOf(s));
		}
		return numbers;
	}
}
