package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import baseball.exception.DuplicatedNumberException;
import baseball.exception.InvalidFiguresNumberException;
import baseball.exception.InvalidInputTypeException;

public class PlayerBaseballNumber {

	private List<Integer> baseballNumbers;

	public PlayerBaseballNumber(List<Integer> playerBaseballNumber) {
		this.baseballNumbers = playerBaseballNumber;
	}

	public static PlayerBaseballNumber createPlayerBaseballNumber(String playerInputNumber) {
		validateNumberFigures(playerInputNumber);
		validateOnlyNumber(playerInputNumber);
		List<Integer> inputNumberList = convertInputTypeToBaseballType(playerInputNumber);

		return new PlayerBaseballNumber(inputNumberList);
	}

	private static void validateDuplicatedNumber(List<Integer> playerNumberList) {

		HashSet<Integer> validateNumberHashSet = new HashSet<>(playerNumberList);

		if(validateNumberHashSet.size() != playerNumberList.size())
			throw new DuplicatedNumberException();
	}

	private static void validateNumberFigures(String inputNumbers) {
		if(inputNumbers.length() != ConstValue.BASEBALL_SIZE)
			throw new InvalidFiguresNumberException();
	}

	private static void validateOnlyNumber(String inputNumbers) {
		for(int i=0; i<inputNumbers.length(); i++) {
			char currentNumber = inputNumbers.charAt(i);

			if(!(currentNumber > '0' && currentNumber <= '9')) {
				throw new InvalidInputTypeException();
			}
		}
	}

	private static List<Integer> convertInputTypeToBaseballType(String inputNumbers) {
		List<Integer> playerBaseballNumbers = new ArrayList<>();

		for(int i=0; i<inputNumbers.length(); i++) {
			String number = Character.toString(inputNumbers.charAt(i));
			playerBaseballNumbers.add(Integer.valueOf(number));
		}

		validateDuplicatedNumber(playerBaseballNumbers);

		return playerBaseballNumbers;

	}


	private void validateBaseballNumberDuplicated(List<Integer> playerBaseballNumbers) {
		HashSet<Integer> validateNumberHashSet = new HashSet<>(playerBaseballNumbers);

		if(baseballNumbers.size() != validateNumberHashSet.size())
			throw new DuplicatedNumberException();
	}

}
