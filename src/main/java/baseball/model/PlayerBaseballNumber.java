package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import baseball.exception.DuplicatedNumberException;
import baseball.exception.InvalidFiguresNumberException;
import baseball.exception.InvalidInputTypeException;

public class PlayerBaseballNumber {

	private List<Integer> baseballNumbers;

	public PlayerBaseballNumber(String playerInputNumber) {
		validateNumberFigures(playerInputNumber);
		validateOnlyNumber(playerInputNumber);
		convertInputTypeToBaseballType(playerInputNumber);
	}

	private void validateNumberFigures(String inputNumbers) {
		if(inputNumbers.length() != ConstValue.BASEBALL_SIZE)
			throw new InvalidFiguresNumberException();
	}

	private void validateOnlyNumber(String inputNumbers) {
		for(int i=0; i<inputNumbers.length(); i++) {
			char currentNumber = inputNumbers.charAt(i);

			if(!(currentNumber > '0' && currentNumber < '9')) {
				throw new InvalidInputTypeException();
			}
		}
	}

	private List<Integer> convertInputTypeToBaseballType(String inputNumbers) {
		List<Integer> playerBaseballNumbers = new ArrayList<>();

		for(int i=0; i<inputNumbers.length(); i++) {
			String number = Character.toString(inputNumbers.charAt(i));
			playerBaseballNumbers.add(Integer.valueOf(number));
		}

		return playerBaseballNumbers;

	}


	private void validateBaseballNumberDuplicated(List<Integer> playerBaseballNumbers) {
		HashSet<Integer> validateNumberHashSet = new HashSet<>(playerBaseballNumbers);

		if(baseballNumbers.size() != validateNumberHashSet.size())
			throw new DuplicatedNumberException();
	}

}
