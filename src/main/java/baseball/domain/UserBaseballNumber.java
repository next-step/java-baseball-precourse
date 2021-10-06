package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class UserBaseballNumber {
    public static List<Integer> setUserBaseballNumber(String inputNumber) {
        List<Integer> userBaseballNumber = new ArrayList<>();

        if(Validation.validateNumberFormat(inputNumber)) {
            for (int i = 0; i < inputNumber.length(); i++) {
                int number = Character.getNumericValue(inputNumber.charAt(i));
                userBaseballNumber.add(number);
            }
        }

        new Validation(userBaseballNumber);
        return  userBaseballNumber;
    }
}
