package baseball.model.utils;

public class ErrorMessage {

    public static final String PREFIX = "[ERROR] ";

    public static String compareLength(int inputSize, int answerSize) {
        return PREFIX + "비교하려는 두 숫자의 길이가 다릅니다. 입력값:" + inputSize + " 정답:" + answerSize;
    }

    public static String numberRange() {
        return PREFIX + "공의 숫자는 1 이상 9 이하여야 합니다.";
    }
}
