package baseball.view;

import baseball.contant.BaseballConstant;
import baseball.contant.BaseballMessage;
import baseball.contant.ExceptionMessage;
import baseball.domain.number.BaseballNumber;
import baseball.domain.number.BaseballNumbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballUserInput {

    public BaseballNumbers getUserNumbers() {
        System.out.print(BaseballMessage.INPUT_USER_NUMBERS);
        String userNumbers = Console.readLine();
        UserInputValidator.validateUserNumbers(userNumbers);
        return convertStringToBaseballNumbers(userNumbers);
    }

    private BaseballNumbers convertStringToBaseballNumbers(String userNumbers) {
        String[] splitUserNumbers = userNumbers.split("");
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (String userNumber : splitUserNumbers) {
            baseballNumbers.add(BaseballNumber.from(Integer.parseInt(userNumber)));
        }
        return BaseballNumbers.from(baseballNumbers);
    }

    public boolean getContinue() {
        String continueStr = Console.readLine();
        UserInputValidator.validateContinue(continueStr);
        int continueInt = Integer.parseInt(continueStr);
        if (continueInt == BaseballConstant.CONTINUE) {
            return true;
        }
        if (continueInt == BaseballConstant.END) {
            return false;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
    }
}
