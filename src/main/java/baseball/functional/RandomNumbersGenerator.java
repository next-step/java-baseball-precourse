package baseball.functional;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import baseball.model.Number;
import baseball.model.Numbers;
import nextstep.utils.Randoms;

public class RandomNumbersGenerator implements NumbersGenerator {
	@Override
	public Numbers createNumbers() {
		LinkedHashSet<Integer> threeDigitNumbers = new LinkedHashSet<>(Numbers.SIZE);
		while (Numbers.SIZE != threeDigitNumbers.size()) {
			threeDigitNumbers.add(Randoms.pickNumberInRange(Number.MIN, Number.MAX));
		}

		return new Numbers(new ArrayList<>(threeDigitNumbers));
	}
}