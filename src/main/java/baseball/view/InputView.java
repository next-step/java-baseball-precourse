package baseball.view;

import baseball.domain.Option;
import baseball.utils.Validation;

public class InputView {

    public final static int BALL_COUNT_LENGTH = 3;

    public static Integer[] inputBalls() {
        String inputValues = Validation.checkInputBalls();
        Integer[] balls = new Integer[BALL_COUNT_LENGTH];
        for (int i =0; i < inputValues.length(); i++) {
            balls[i] = Character.getNumericValue(inputValues.charAt(i));
        }
        return balls;
    }

    public static boolean inputExitOrRestart() {
        String inputValues = Validation.checkInputExitOrRestart();
        if (Option.RESTART.getCode().equals(inputValues))
            return Option.RESTART.isValue();
        return Option.EXIT.isValue();
    }


}

