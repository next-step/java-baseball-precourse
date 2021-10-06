package baseball;


public class UserNum {
    private String inputStr;
    private String errorMsg;
    private int num;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public UserNum(String num) {
        this.inputStr = num;
    }

    public boolean isCorrectNum() {
        errorMsg = "";
        if (!isNum()) {
            errorMsg = "[ERROR] '" + num + "'은 숫자 형식이 아닙니다.";
            return false;
        }
        if (!isAcceptableRange()) {
            errorMsg = "[ERROR] '" + num + "'은 "+MIN_NUMBER+"와 "+MAX_NUMBER+" 사이의 숫자 이어야합니다.";
            return false;
        }
        return true;
    }

    private boolean isNum() {
        try {
            num = Integer.parseInt(inputStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isAcceptableRange() {
        return MIN_NUMBER <= this.num && this.num <= MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNum userNum = (UserNum) o;
        return num == userNum.num;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public int getNum() {
        return num;
    }
}
