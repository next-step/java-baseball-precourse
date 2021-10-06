package baseball.domain;

import baseball.exception.BaseballException;
import baseball.exception.ErrorMessage;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ComputerBaseballNumber implements BaseballNumber {

    private static final int MAX_NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private static Randoms randoms;

    @Override
    public List<Integer> createNumbers() {
        Set<Integer> computerNumbers = new LinkedHashSet<>();

        while (computerNumbers.size() < MAX_NUMBER_LENGTH) {
            int pickNumber = pickNumber();
            validateNumber(pickNumber);
            computerNumbers.add(pickNumber);
        }

        return new ArrayList<>(computerNumbers);
    }

    private static int pickNumber() {
        return randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    private static void validateNumber(int number) {
        if (number < 1 || number > 9) {
            throw new BaseballException(ErrorMessage.ESCAPE_NUMBER_EXCEPTION);
        }
    }
}
