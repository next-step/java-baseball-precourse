package baseball;


public class UserNum {
    private String inputStr;
    private int num;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public UserNum(String num) {
        this.inputStr = num;
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
        if(MIN_NUMBER <= this.num && this.num <= MAX_NUMBER) {
            return true;
        }
        return false;
    }
}
