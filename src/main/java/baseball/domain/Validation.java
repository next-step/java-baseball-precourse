package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    public static final String ERROR_MSG = "[ERROR] 서로 다른 세 자리의 자를 입력해주세요 :)";

    public Validation() {}

    public Boolean isNum(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MSG);
            return false;
        }
    }

    public Boolean isCorrectLength(String input) {
        if (input.length() != 3) {
            makeException();
            return false;
        }
        return true;
    }

    public Boolean isDiffNum(String input) {
        List<String> tempNum = new ArrayList<>();
        tempNum = makeTmpNum(input, tempNum);
        if (tempNum.size() != 3) {
            makeException();
            return false;
        }
        return true;
    }

    public Boolean isCorrectRange(String input) {
        if (input.contains("0")) {
            makeException();
            return false;
        }
        return true;
    }

    public List<String> makeTmpNum(String input, List<String> tempNum) {
        for (String x : input.split("")) {
            tempNum = isContain(x, tempNum);
        }
        return tempNum;
    }

    public List<String> isContain(String x, List<String> tempNum) {
        if (!tempNum.contains(x)) {
            tempNum.add(x);
        }
        return tempNum;
    }

    public void makeException() {
        try {
            throw new Exception(ERROR_MSG);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
