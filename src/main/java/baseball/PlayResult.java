package baseball;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PlayResult {

    private static Map<Status, Integer> statusMap = new HashMap<>();

    public PlayResult() {
        statusMap.clear();
    }

    public static PlayResult of() {
        return new PlayResult();
    }

    public void reulstCount(Status ballStatus) {
        if (!statusMap.containsKey(ballStatus)) {
            statusMap.put(ballStatus, 1);
            return;
        }
        statusMap.put(ballStatus, statusMap.get(ballStatus) + 1);
    }

    public int strikeCount() {
        return statusMap.get(Status.STRIKE) != null ? statusMap.get(Status.STRIKE) : 0;
    }

    public int ballCount() {
        return statusMap.get(Status.BALL);
    }

    public int nothingCount() {
        return statusMap.get(Status.NOTHING);
    }

    public Map<Status, Integer> resultGame() {
        return Collections.unmodifiableMap(statusMap);
    }

}


