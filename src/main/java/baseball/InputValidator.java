package baseball;

public class InputValidator {
    public boolean validateLength(String[] inputs) {
        return inputs.length == GlobalVariables.MAX_BALL_CNT;
    }

    public boolean validateRange(int num) {
        return num >= GlobalVariables.MIN_BALL_NUMBER && num <= GlobalVariables.MAX_BALL_NUMBER;
    }
}
