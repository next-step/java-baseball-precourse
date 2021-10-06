package baseball.domain;

import nextstep.utils.Randoms;

public class RandomNumberPickerImpl implements IRandomNumberPicker {
    @Override
    public int pick(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
