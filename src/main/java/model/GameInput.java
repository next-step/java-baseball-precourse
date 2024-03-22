package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GameInput {

	private static final int INPUT_SIZE = 3;

	private final List<Integer> inputNums = new LinkedList<>();

	public GameInput(final String input) {
		checkNumberSize(input);
		checkDuplication(input);

		for (char num : input.toCharArray()) {
			inputNums.add(Character.getNumericValue(num));
		}
	}

	public List<Integer> getValues() {
		return new LinkedList<>(inputNums);
	}

	public boolean hasSameValue(final List<Integer> other) {
		if (inputNums.size() != other.size()) return false;
		for (int i = 0; i < inputNums.size(); i++) {
			if (!inputNums.get(i).equals(other.get(i))) return false;
		}
		return true;
	}

	private void checkNumberSize(final String input) {
		if (input.length() != INPUT_SIZE) throw new IllegalArgumentException();
	}

	private void checkDuplication(final String input) {
		final String[] inputNums = input.split("");
		final Set<String> distinctNums = new HashSet<>(Arrays.asList(inputNums));

		if (inputNums.length != distinctNums.size()) throw new IllegalArgumentException();
	}
}
