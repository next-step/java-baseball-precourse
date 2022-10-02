package baseball.domain;

import static baseball.common.COMMON_CONSTANT.*;
import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMachine {
	private final List<Integer> numbers = new ArrayList<>();

	public RandomMachine() {
		while(isComplete()){
			addNumber();
		}
	}
	private void addNumber() {
		Integer number = Randoms.pickNumberInRange(START_RANGE,END_RANGE);
		if(!numbers.contains(number)){
			numbers.add(number);
		}
	}
	private boolean isComplete() {
		return numbers.size() < NUMBER_RANGE;
	}

	public List<Integer> getNumber(){
		return numbers;
	}
}
