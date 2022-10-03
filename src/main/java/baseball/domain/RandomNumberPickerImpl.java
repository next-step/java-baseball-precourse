package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPickerImpl implements IRandomNumberPicker {
    @Override
    public int pick(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
