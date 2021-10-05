package baseball.view;

import static baseball.common.Constants.*;

public class OutputView {


    public OutputView() {

    }

    public static String getStrike(int no) {
        return no + STRIKE_MSG;
    }

    public static String getBall(int no) {
        return no + BALL_MSG;
    }

    public static String getNoting() {
        return NOTHING_MSG;
    }

}
