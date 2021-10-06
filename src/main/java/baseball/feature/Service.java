package baseball.feature;

import baseball.domain.CheckResult;

public interface Service {

    Integer[] makeRandomDigit(int num);

    boolean isValid(String input);

    //String to int
    Integer[] stringToInt(String input);

    CheckResult getCheckResult(Integer[] answer, Integer[] inputNums);
}