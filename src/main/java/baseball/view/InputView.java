package baseball.view;

import baseball.domain.Option;
import baseball.utils.Validation;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public class InputView {

    public final static int BALL_COUNT_LENGTH = 3;

    /**
     * Gamer가 입력한 서로 다른 3자리 공 입력
     * @return Integer[]
     */
    public static Integer[] inputBalls() {
        String inputValues = Validation.checkInputBalls();
        Integer[] balls = new Integer[BALL_COUNT_LENGTH];
        for (int i =0; i < inputValues.length(); i++) {
            balls[i] = Character.getNumericValue(inputValues.charAt(i));
        }
        return balls;
    }

    /**
     * 게임 종료 및 재시작 값 입력
     * @return boolean
     */
    public static boolean inputExitOrRestart() {
        String inputValues = Validation.checkInputExitOrRestart();
        if (Option.RESTART.getCode().equals(inputValues))
            return Option.RESTART.isValue();
        return Option.EXIT.isValue();
    }


}

