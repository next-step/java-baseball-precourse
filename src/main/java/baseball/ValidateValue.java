package baseball;

import java.util.ArrayList;
import java.util.List;

public class ValidateValue {
    public static String errorMsg = "[ERROR] 서로 다른 세 자리의 자를 입력해주세요 :)";
    public ValidateValue() {

    }

    public Boolean isNum (String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(errorMsg);
            return false;
        }
    }

    public Boolean isCorrectLength (String input) {
        try {
            checkLength(input);
            if (input.length() != 3) {
                throw new Exception(errorMsg);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void checkLength (String input) {
//        if (input.length() != 3) {
//            throw new Exception(errorMsg);
//        }
    }

    public Boolean isDiffNum (String input) {
        try {
            List<String> tempNum = new ArrayList<>();
            for (String x : input.split("")) {
                if (tempNum.contains(x)) { throw new Exception(errorMsg); }
                tempNum.add(x);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
