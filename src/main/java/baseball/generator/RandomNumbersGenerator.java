package baseball.generator;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import baseball.domain.Number;
import baseball.domain.Numbers;
import nextstep.utils.Randoms;

public class RandomNumbersGenerator implements NumbersGenerator {
	@Override
	public Numbers createNumbers() {
		LinkedHashSet<Integer> randomNumbers = new LinkedHashSet<>(Numbers.IMMUTABLE_SIZE);
		while (Numbers.IMMUTABLE_SIZE != randomNumbers.size()) {
			randomNumbers.add(Randoms.pickNumberInRange(Number.MIN, Number.MAX));
		}

		return new Numbers(new ArrayList<>(randomNumbers));
	}
}