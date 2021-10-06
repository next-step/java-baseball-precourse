package baseball;

import java.util.ArrayList;

public class BallCollection extends ArrayList<Ball> {
    public MATCH_RESULT match(Ball counterBall) {
        MATCH_RESULT result = MATCH_RESULT.NOTHING;

        for (Ball myBall : this) {
            result = overwriteIfValid(result, myBall.match(counterBall));
        }

        return result;
    }

    public MATCH_RESULT overwriteIfValid(MATCH_RESULT oldValue, MATCH_RESULT newValue) {
        return oldValue == MATCH_RESULT.NOTHING ? newValue : oldValue;
    }
}
