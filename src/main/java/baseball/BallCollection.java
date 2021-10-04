package baseball;

import java.util.ArrayList;

public class BallCollection extends ArrayList<Ball> {
    public MATCH_RESULT match(Ball counterBall) {
        MATCH_RESULT result = MATCH_RESULT.NOTHING;

        // TODO: depth가 1 이상이므로 다른 방식을 찾아야 함
        for (Ball myBall : this) {
            result = myBall.match(counterBall);

            if (result == MATCH_RESULT.NOTHING) {
                continue;
            }

            break;
        }

        return result;
    }
}
