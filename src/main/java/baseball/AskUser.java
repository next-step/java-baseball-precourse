package baseball;

import nextstep.utils.Console;

public class AskUser {
    public static String ASK_NUMBER_INPUT = "숫자를 입력해주세요: ";

    private ValidateValue validateValue;

    public AskUser() {
        this.validateValue = new ValidateValue();
    }

    public String askUser () {
        System.out.print(ASK_NUMBER_INPUT);
        String inputVal = Console.readLine();
        if (checkNum(inputVal) && checkCorrectLen(inputVal) && checkCorrectNum(inputVal)) {
            return inputVal;
        }
        return "";
    }

    public Boolean checkNum (String inputVal) {
        if (validateValue.isNum(inputVal)) {
            return true;
        }
        return false;
    }

    public Boolean checkCorrectLen (String inputVal) {
        if (validateValue.isCorrectLength(inputVal)) {
            return true;
        }
        return false;
    }

    public Boolean checkCorrectNum (String inputVal) {
        if (validateValue.isDiffNum(inputVal)) {
            return true;
        }
        return false;
    }
}
